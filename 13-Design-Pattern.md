# 設計模式

- 設計模式是在某種環境(Context)下針對某個問題的某種解決方案
    - 情境：不斷重複出現的某種情況，例如：鑰匙放在車上了
    - 問題：在某個情境下想達到的目標，例如：我要怎麼才能準時上班
    - 解決方案：針對情境和問題的通用設計，例如：破窗而入車
- Keep it Simple (KISS)：不要過度使用設計模式讓程式碼過度工程化
- 如果你現在不需要，就別做

# 其他模式

## 橋接模式(Bridge Pattern)

- 通過將類的實現和抽象放在不同的層次而使他們可以分別獨立改變
```java
public abstract class AbstractRemoteControl {
    protected TV implementor;
    public void function() {
        implementor.controlFunction()
    }
}

public class ConcreteRemoteControl extends AbstarctRemoteControl{
    public void setChannel() {
        //
        function();
    }
}

public abstract class TV {
    public void controlFunction();
}

public class ConcreteTV1 extends TV {
    public void controlFunction() {
        //
    }
}
public class ConcreteTV2 extends TV {
    public void controlFunction() {
        //
    }
}
```

