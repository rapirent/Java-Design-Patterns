# 狀態模式


- 狀態模式允許對象在內部狀態改變時改變它的行為，對象看起來好像修改了他的類別內容
    - 狀態模式將「狀態」封裝成獨立的類別，並將「動作」委託到代表當時狀態的對象
    - 行為會隨著當時狀態改變而改變
    - 我們可以透過簡單引用不同的狀態類別實例組合達到修改主要業務類別邏輯內容的效果

```java
public class Context {
    private State state;
    public void request() {
        state.handle()
    }
}

public interface State {
    public void handle();
}

public class ConcreteStateA implements State {
    @Override
    public void handle() {
        //...
    }
}

public class ConcreteStateB implements State {
    @Override
    public void handle() {
        //...
    }
}

```

# 策略模式比較

- 狀態模式很像策略模式，同樣都是在主要業務邏輯中使用類別來修改自身邏輯
    - 但一般並不會讓客戶知道狀態類別的存在，但卻會讓客戶知道策略/算法類別並選擇
    - 策略模式一般只使用特定幾個策略類別，但狀態模式卻會頻繁使用全部的狀態類別

# 缺點

- 因為狀態模式在主要邏輯中使用狀態類別，卻又在狀態類別中與主要邏輯類別交互以決定下一個狀態，所以會造成「circular reference」的問題




