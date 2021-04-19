# 轉接器模式

- 轉接器模式(Adapter pattern)將一個類型的介面轉換成客戶期望的另一個介面（提供需要的方法），讓原本不兼容的類型可以互相溝通
- 有對象轉接器還有類別轉接器：
    - 類別轉接器需要多重繼承：不需要重新實現整個被轉接者類別，可以覆蓋被轉接者的行為從而利用繼承
        - 僅僅需要一個類別轉接器
        - 但當被轉接者的子類加入新的行為，則需要改變整個轉接器的實作，而對象轉接器只需要將成員改為該子類即可
    - 對象轉接器使用對象組合（介面擁有對象實例），這樣該對象的任何子類都可以被此介面包裝
        - 需要轉接器和被轉接者
- 轉接器模式的範例：
    - java.util中的Iterator介面轉接到java.util中的Collection介面

```java
// 對象轉接器
public interface Target {
    public void request();
}
public class Adapter implements Target {
    private Adaptee adaptee;
    public void request() {
        this.adaptee.specificRequest();
    }
}
```


```cpp
/** ----------- **/
// 類轉接器
class Target {
    public:
        void request();
}
class Adapter: class Target, class Adaptee {
    public:
        void request() {
            specificRequest();
        }
}
```

