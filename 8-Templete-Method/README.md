# 模板方法模式

- 茶和咖啡的故事：兩者都需要熱水沖泡，也需要將沖泡好的飲料放入杯子中以利加入砂糖或檸檬
- 模板方法模式在模板方法中定義一個算法的骨架，並將一些步驟延遲到子類中，模板方法使得子類在不改變算法結構的狀況下重新定義演算法的某些步驟
    - 模板方法類確保算法只存在一個地方，讓代碼重用提高，並且提供了一個算法的框架，利於維護

- 範例：許多程式語言STL中的排序演算法、Java中的字節流操作、Swing模板

```java
public abstract class AbstractClass {
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
    }
    public abstract void primitiveOperation1() {

    }
    public abstract void primitiveOperation2() {

    }
    public final void concreteOperation() {
        //聲明為final讓子類無法覆蓋他
    }
    public void hook() {} // hook什麼也不做，讓子類視情況決定是否覆蓋它
}
public class ConcreteClass extends AbstractClass {
    @Override
    public void primitiveOperation1() {

    }
    @Override
    public void primitiveOperation2() {

    }
}
```

- 鉤子讓子類視情況選擇覆蓋它，從而改變模板方法本身
    - 鉤子讓子類可以實現算法中可選的部分
    - 子類能夠有機會對模板方法中某些即將發生的（或剛剛發生的）步驟做出反應

```java
//鉤子的範例
public abstract class CaffeineBeverageWithHook {
    public final prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    protected abstract void brew();
    protected abstract void addCondiments();
    protected final void boilWater() {
        System.out.println("Boiling Water");
    }
    protected final void pourInCup() {
        System.out.println("Pouring into cup");
    }
    protected boolean customerWantsCondiments() {
        // hook 鉤子
        return true;
    }
}

public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
    @Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startWith("y")) {
            return true;
        }
        else {
            return false;
        }
    }
    private String getUserInput() {
        //...
    }
}
```

- 當子類「必須」提供算法某個方法或步驟時就用抽象方法
- 如果算法的某個部分是可選的，則使用鉤子

# 好萊塢原則

- ***好萊塢原則***：別打電話給（調用）我們，我們會打電話給（調用）你
    - 防止「依賴腐敗」：高層級組件依賴低層級組件，低層級組件又依賴高層級組件，而高層級組件又依賴側邊組件，側邊組件又依賴低層級組件，沒有人能搞懂整個系統架構設計
    - 透過好萊塢原則，我們允許低層級組件將自己掛勾到系統上，但是高層級組件會決定什麼時候和怎樣使用這些低層級組件

# 和策略模式的比較
- 我們很容易將模板方法模式和策略模式搞混
    - 策略模式使用對象組合，看起來很像排序模板中的`compareTo`方法
- 策略模式中，組合的類別實現了整個演算法；`compareTo`方法只是實現了算法中的一部分，所以更像模板方法
    - 策略模式定義了一個算法家族，讓這些算法可以互換，每一個算法都被封裝起來，所以客戶可以輕易使用不同算法：策略模式利用對象組合讓客戶挑選算法，藉由對象組合委派，從而在運行時改變算法
    - 模板方法定義了一個算法「綱要」，由模板的子類定義算法其中的某些步驟的內容，個別步驟從而可以有不同的實作細節但算法結構依舊保持不變：模板方法模式利用繼承讓細節明確，從而減少代碼重用，但依賴父模板類別

- 模板方法模式是最常被使用到的模式
