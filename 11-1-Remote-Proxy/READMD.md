# 代理模式

- 代理模式為另一個對象提供一個替身或代表以控制對這個對象的訪問
- 代理的對象通常是遠端對象、創建開銷大的對象或需要安全控制的對象
    - 我們藉由代理對象來控制訪問
- 代理模式將客戶(使用者)對主題(subject)施加的方法調用攔截下來，造成間接的級別區分
    - 這種間接級別可以達成：
        - 將請求分發到遠端主題(遠端代理)
        - 給創建資源開銷大的對象提供代表(虛擬代理)
        - 提供某些級別的保護：決定哪些客戶能調用哪些方法(保護代理)

```java
public interface Subject {
    public void request();
}

public RealSubject implements Subject {
    public void request() {
        //
    }
}

public Proxy {
    protected Subject subject = null;
    public void request() {
        subject = new RealSubject();
        //
    }
}

```

- 可以使用工廠模式，提供一個工廠方法來實例化並返回一個主題：在使用代理包裝該主題後返回，這樣就能確保使用者拿到的是代理而飛該主題本身
- 緩存代理(Caching Proxy)會緩存之前創建的對象，在收到請求時盡可能返回他

# 代理模式和裝飾者模式的區別

- 裝飾者模式為對象增加行為
- 代理模式控制對象的訪問：Proxy控制了某個對象的訪問
    - 代理將客戶端從這個對象解耦，客戶不需要拿到該對象才能控制他的行為

- 代理包裝主題、裝飾者包裝對象

- 裝飾者模式不會實例化對象，但代理模式實例化主題
- 客戶使用代理模式時，主題(對象)可能不存在，但裝飾者模式被使用時，該對象都存在
- 代理通常不會將一個主題包裝多次

# 代理模式和適配器模式的區別

- 代理模式和適配器模式都擋在其他對象前面，並負責將請求轉發給他們
    - 但，適配器模式會`改變對象適配的介面`
    - 代理模式則會`實現同樣的介面`
- 保護代理某種層面上跟適配器很像，因為他會根據客戶的不同角色來決定客戶是否可以訪問特定的方法：保護代理會提供部分接口給客戶

# 比較

- 裝飾者模式：包裝另一個對象，提供額外的行為
- 外觀模式；包裝另一個對象，提供不同的介面
- 代理模式：包裝另一個杜象，控制對他的訪問
- 適配器模式：包裝許多對象以簡化他們的介面

# 其他的代理模式

- 防火牆代理(Firewall Proxy): 控制網路資源的訪問，保護主題免於侵害
- 智能引用代理(Smart Reference Proxy): 當主題被引用時進行額外的動作，像是計算一個對象被引用的次數
- 暫存代理(Caching Proxy)：為開銷大的運算結果提供暫時儲存，允許多個用戶共享結果以減少間算或網路延遲
- 同步代理(Synchronization Proxy)：在多線程(執行緒)的情況下為主題提供安全訪問
- 複雜隱藏代理(Complexity Hiding Proxy)/外觀代理(Facade Proxy)：隱藏一個類別的複雜集合的細節，提供訪問控制
    - 外觀代理控制訪問，外觀模式提供另一組介面
- 寫入時複製代理(Copy-On-Write Proxy)：用來控制對象的複製，延遲複製的執行，直到使用者真的需要為止，也是一種虛擬代理
# 遠端代理

- 遠程代理(remote proxy)是遠程對象的本地代表
    - 遠程對象是運行在另一條執行緒(地址空間)上對象(又好比不同的JVM堆中)
    - 本地代表是一種可以由本地方法調用的對象
    - 我們對遠程代理調用的方法，其實只是調用在本地堆中的「代理對象」的方法，再由這個代理對象處理相關的網路溝通底層細節

## Java RMI

- Java RMI 通過客戶輔助對象與服務輔助對象提供遠程代理服務，兩個對象建立 socket 溝通
    - Java RMI 將客戶輔助對象稱為 stub，服務輔助對象稱為 skeleton

- Java RMI 和 RPC 的差別：
    - RMI 是物件導向的：通過 Stub 對象作為遠程接口進行遠程方法的調用。
        - 每個遠程方法都具有方法簽名。如果一個方法在伺服器上執行，但是沒有相匹配的簽名被添加到這個遠程接口(stub)上，那麼這個新方法就不能被RMI客戶方所調用。
        - RMI的結果統一由外部數據表示 (External Data Representation, XDR) 語言表示
    - RPC中是通過網絡服務協議向遠程主機發送請求，請求包含了一個參數集和一個文本值，通常形成「classname.methodname(參數集)」的形式。RPC遠程主機就去搜索與之相匹配的類和方法，找到後就執行方法並把結果編碼，通過網絡協議發回。

(ref: https://kknews.cc/code/2lx53pz.html)

- Java RMI必須透過 rmic 來開啟 IIOP 並且使用 RMI registry 註冊服務，stub 返回的類型必須是 Java 原型類型或可序列化 (Serializable)
- 可以透過 Dynamic class downloading ，使用 URL 來取得 stub (類似服務發現)

```java
import java.rmi.*;

public interface MyRemote extends Remote {
    public String sayHello() throws RemoteException;
}

```

```java
import java.rmi.*;
import java.rmi.server;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public String sayHello() {
        return "Server says, `Hey`";
    }

    public MyRemoteImpl throws RemoteException {
        //
    }

    public static void main (String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

```

```java
//client
import java.rmi.*;

public class MyRemoteClient {
    public static void main (String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();

            System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

```
