# 裝飾器模式

- 裝飾器動態地將責任附加在對象上
- 對於擴充功能，裝飾器模式提供了比繼承更有彈性的方式
- 裝飾者(Decorator)和被裝飾者(部件, Component)都同屬同一個類型，使用繼承達到「類型匹配」而非「獲得行為」。
- 裝飾者通常用工廠模式或是生成器模式來創建
- 無法針對特定的組件類型進行特殊的事情，如果把程式碼寫成依賴於具體的組件類型，則裝飾者模式會導致程式碼出問題：裝飾者包裝組件後會造成類型改變
- 如果的確針對特定的具體組件類型編程，必須思考「是否需要使用裝飾者模式」
- 使用裝飾者模式會造成大量的小類，很難管理

```java
public interface Component {
    public void methodA() {

    }
    public void methodB() {

    }
}

public class ConcreteComponent implements Component {
    @override
    public void methodA() {}
    @override
    public void methodB() {}
}

public abstract class Decorator implements Component {
    @override
    public void methodA() {}
    @override
    public void methodB() {}
}

public class ConcreteDecoratorA extends Decorator {
    protected Component wrappedObj; //裝飾器包裝的Component
    @override
    public void methodA();
    @override
    public voide methodA();
}

public class ConcreteDecoratorB extends Decorator {
    protected Component wrappedObj;
    protected Component newState; //裝飾器可以加入額外的狀態
    @override
    public void methodA();
    @override
    public void methodB();
}
```

# 設計原則

- 一個類型應該要對擴展開放（能夠擴展），對修改關閉（免於改變）。
- composition 和 delegation 可以在運行時達到繼承行為的效果。


