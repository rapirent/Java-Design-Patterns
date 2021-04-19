# 單例模式

- 單例模式確保一個類型只有一個實例，並提供一個全局訪問點
- 得小心多線程問題：使用鎖來強制同步（Java中的synchronized, volatile）、急切創建實例，直接在單例類型中創建實例而不延遲實例化。

```java
public class Singleton {
    private static uniqueInstance = null;
    private Singleton() {}
    public static synchronized getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

```

```java
public class Singleton {
    private static uniqueInstance = new Singleton();
    private Singleton() {}
    public static synchronized getInstance() {
        return uniqueInstance;
    }
}

```

- 可以使用 Enum 來建造單例（ref: https://stackoverflow.com/questions/26285520/implementing-singleton-with-an-enum-in-java）

```java
public enum MySingleton {
    INSTANCE;
    private MySingleton() {
        System.out.println("Here");
    }
}

```
