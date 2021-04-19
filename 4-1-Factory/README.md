# 工廠模式

- 工廠方法模式定義了一個創建對象的介面，但由子類決定要實例化的類別是哪一個。工廠模式把實例化推遲到子類
- 也有靜態工廠：使用靜態方法創建工廠，這是因為不需要使用創建對象的方法來實例化對象。
- 簡單工廠方法中，工廠是另一個由創建者使用的對象
- 工廠方法用來處理對象的創建，並將這樣的行為封裝在子類中。這樣，客戶程式中關於超類的代碼就和子類對象創建程式碼解耦了。
    - Creator和ConcreteProduct之間不是緊耦合，增加或改變Product的實現並不會影響Creator

```java
//使用String來指定所要的產品，但在實作時不一定是String
abstract Product factoryMethod(String type)
```

- 工廠方法將生產知識透過單一方法的繼承封裝進各個創建者
- 父類別以單一方法呼叫「工廠方法」
- 工廠方法模式定義了一個創建對象的接口，但由子類決定要實例化的類是哪一個。工廠方法讓類把實例化推遲到子類

```java
abstract public class Product {
    //...
}
public class CurrentProduct extends Product {
    //...
}
abstract public class Creator {
    abstract public Product factoryMethod(String type);
    public void anOperation();
}
public class ConcreteCreator extends Creator {
    public Product factoryMethod(String type);
}
```

# 設計要點

- 將創建對象的程式碼封裝起來，集中在一個對象或方法中，可以避免程式碼的重複，並且方便維護：在實際實例化時，只會依賴介面而不是具體類別
- 工廠方法仍然必須使用具體類別來實例化真正的對象
- 看到類c語言使用new時，應該想到「實例化」一個類別，這樣是針對「實作」編程，而非「介面」
- 我們需要盡量推遲實例化的時機，讓程式碼充滿彈性
- 「封裝創建對象的程式碼」
- Dependency Inversion Principle, 依賴倒置原則：不讓高層組件依賴低層組件，並且不管高層或低層組件，兩者都應該依賴於對象
    - 變數不可以持有具體類的引用
    - 不要讓類派生自具體類
    - 不要覆蓋基類中已實現的方法
    - e.g: PizzaStore是高層組件，Pizza實現是低層組件，工廠模式讓Pizza實現依賴PizzaStore
