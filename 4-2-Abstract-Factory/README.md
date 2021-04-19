# 抽象工廠模式

- 抽象工廠模式提供一個用於創建相關或依賴對象家族的介面，而不需要明確指定具體類別。

```java
public interface AbstractFactory {
    // 是ProductA和ProductB的組合！
    public ProductA CreateProductA();
    public ProductB CreateProductB();
}
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA CreateProductA();
    @Override
    public ProductB CreateProductB();
}
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA CreateProductA();
    @Override
    public ProductB CreateProductB();
}

public interface ProductA {
    //...
}
public class ProductA1 implements ProductA {
    //...
}
public class ProductA2 implements ProductA {
    //...
}
public interface ProductB {
    //...
}
public class ProductB1 implements ProductB {
    //...
}
public class ProductB2 implements ProductB {
    //...
}

public class Client {
    //AbstractFactory af = ...
}

```

- 工廠方法使用類型：使用類型的繼承，而抽象工廠方法使用「對象」：通過對象的組合
    - 使用工廠方法創建對象需要擴展一個類型，並且覆蓋這個類型的工廠方法：工廠方法只不過是創建一個產品，所以不需要更高層級的抽象介面
    - 工廠方法利用子類來創建對象，客戶只需要他們所使用的抽象類型，由子類來決定具體類型
    - 使用抽象工廠方法創建對象需要先實例化其提供的抽象介面：對象的創建被實現在工廠介面所暴露出來的方法中
    - 抽象工廠方法提供一個用來創建一個「產品家族」的介面，在介面中使用抽象類型讓子類定義具體產品產生的細節（工廠模式），使用這個工廠介面需要先實例化，這樣就可以將相關的產品集合起來成一個家族：抽象工廠方法使用工廠方法來產生產品，但提供更高層級的抽象介面

