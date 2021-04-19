# 保護代理

- 通過運行時動態地創建代理類來實現一或多個接口，並將方法的調用轉發到指定的類別

## Java Dynamic Proxy

- Java 為我們建立了 Proxy 類別，該代理並不是我們直接實現的：我們透過 InvocationHandler，他響應對代理的任何調用，InocationHandler是Proxy的反射

- 因為 Java 的 Proxy 類別是運行時才創建出來，根據我們使用getNewProxyInstance才動態創建出來，所以被稱為動態代理
    - 我們可以使用 Java 的 isProxyClass() 知道是否為動態代理類別

```java
public interface Subject {
    public void request();
}

public class RealSubject implements Subject {
    public void request() {
        //
    }
}

public class Proxy implements Subject {
    public void request() {

    }
}

```

```java

public interface InvocationHandler {
    public void invoke();
}

public class InvocationHandler implements InvocationHandler {
    public void invoke(Object proxy, Method method, Object[] args) {
        // call when proxy calls the method, e.g request()
    }
}

```
