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
- 優點抽象層和實現層可以獨立擴展，針對抽象類的實作不會影響到使用者
- 用途：跨平台應用
- 缺點：增加複雜度

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

## 生成器模式 (Build Pattern)

- 將創建過程封裝到一個對象中，如此可以將複雜對象的創建（比如說包含許多步驟）封裝起來
    - 允許對象的創建可以包含許多步驟，並且可以隨著情況改變過程
    - 和***只有「一個步驟」的工廠模式***不一樣
- 隱藏產品內部的實現，且產品的實現可以被替換：客戶只看到一個抽象的介面


```java

public abstract class AbstractBuilder {
    protected Object object = null;
    public void buildObject();
    public void modifyObject();
}

public class ConcreteBuilder extends AbstractBuilder {
    @Override
    public void buildObject() {
        this.object = new COncreteObject();
    }

    @Override
    public void modifyObject() {
        //
    }
}

```

```java
public class Client {
    protected AbstractBuilder builder = null
    public void constructObject() {
        this.builder = new ConcreteBuilder();
        this.builder.buildObject();
        this.builder.modifyObject();
        //
    }
}
```


## 責任鏈模式 (Chain of Responsibility Pattern)

- 為某個特定請求創建一責任鏈，每個對象依序檢查這個請求，對其處理或是將其傳給責任鏈中的下一個對象
- 優點：可以將請求的發送者和接受者解耦
    - 可以簡化對象：不需要知道鏈結的構造
    - 可以藉由改變鏈結內的對象或順序而動態的調整處理邏輯
- 責任鏈模式並不能保證請求一定會被執行，有可能沒有任何的對象處理請求（可能落在責任鏈之外）
- 經常用於視窗系統中
- 缺點：不易觀察運行時的狀態

```java

public abstract class Handler {
    protected Handler successor = null;
    public void setSuccessor();
    public void handlerRequest();
}

public class ConcreteHandler1 extends Handler {
    public ConcreteHandler1() {
        this.successor = new ConcreteHandler2();
    }
    public void handlerRequest() {
        // something
        try {

        } catch (Exception e) {
            successor.handlerRequest();
        }
    }
}

public class ConcreteHandler2 extends Handler {
    public ConcreteHandler2() {
        this.successor = new ConcreteHandler3();
    }
    public void handlerRequest() {
        // something
        try {

        } catch (Exception e) {
            successor.handlerRequest();
        }
    }
}

public class ConcreteHandler3 extends Handler {
    public void handlerRequest() {
        // something
    }
}

```

或

```java

public abstract class Handler {
    protected Handler successor = null;
    public void setSuccessor();
    public void handlerRequest();
}

public class ConcreteHandler1 extends Handler {
    public ConcreteHandler1() {
        this.successor = new ConcreteHandler2();
    }
    public void handlerRequest() {
        // something
        try {

        } catch (Exception e) {
            successor.handlerRequest();
        }
    }
}

public class ConcreteHandler2 extends Handler {
    public ConcreteHandler2() {
        this.successor = new ConcreteHandler3();
    }
    public void handlerRequest() {
        // something
        try {

        } catch (Exception e) {
            successor.handlerRequest();
        }
    }
}

public class ConcreteHandler3 extends Handler {
    public void handlerRequest() {
        // something
    }
}
```

# 繩量模式 (Flyweight Pattern)

- 藉由盡可能共享所有相似物件的資料來減少記憶體的浪費
    - 盡可能讓共享的物件小 (flyweight)
- 缺點：Flyweight的單個邏輯實例無法擁有獨立而不同的行為
- 用途：java中的string pool


ref: http://corrupt003-design-pattern.blogspot.com/2017/01/flyweight-pattern.html
```java

public abstract class Flyweight {
    protected String state;
    public void operation();
}

public class ConcreteFlyweight1 extends Flyweight {
    @Override
    public void operation() {
        //
    }
}

public class ConcreteFlyweight2 extends Flyweight {
    @Override
    public void operation() {
        //
    }
}

public class FlyweightFactory {
    //只是範例，不一定要ArrayList
    private static ArrayList<Flyweight> flyweightList = new ArrayList<Flyweight>();
    public void operationAll() {

    }
}

```

## 解釋器模式 (Interpreter Pattern)

- 對於一個簡單的語言，將每一個語法規則表示為一個類別，便於實現
- 優點：可以輕易擴充或改變語言規則
    - 在類別結構中加入新的方法，可以增加新的行為
- 用途：實現腳本語言
- 缺點：語法規則太大時，結構可能會非常複雜

```java

public interface Expression {
    public void interpret(String context);
}

public class Variable implements Expression {
    public void void interpret(String context) {

    }
}

public class FlyCommand implements Expression {
    public void void interpret(String context) {

    }
}

public class RightCommand implements Expression {
    public void void interpret(String context) {

    }
}

public class Repetition implements Expression {
    protected Expression expression;
    protected Object varaible;
    public void void interpret(String context) {

    }
}

public class Sqeuence implements Expression {
    protected Expression expression1;
    protected Expression expression2;
    public void void interpret(String context) {

    }
}


```

## 中介者模式 (Mediator Pattern)

- 每個對象在自己改變狀態時告訴中介者，且會對中介者發出的請求作出回應
- 所有對象透過中介者來互動
- 和觀察者模式類似，但觀察者模式只是代表訂閱者和發布者之間的解耦，而中介者接受對象的發布並且訂閱他
- 優點：將控制邏輯集中、讓對象彼此解耦，從而增加對象的復用性
- 常用來作為GUI系統的協調
- 缺點：中介者容易過於肥大複雜

```java
//ref: https://en.wikipedia.org/wiki/Mediator_pattern
public class Thing {
    protected String value = null;
    public String getValue() {
        return this.value;
    }
    public void setValue(Mediator mediator, String value) {
        this.value = value;

    }
}

public class Mediator {
    private final HashMap<String, Storage> stroageMap = new HashMap<>();
    private final ArrayList<Consumer<String>> observers = new ArrayList<>();
    //default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
    public void setValue(String storageName, String value) {
        Storage storage = storageMap.computeIfAbsent(sotrageName, name -> new Storage());
        storage.setValue(this, storageName, value);
    }

    public Optional<Storage> getValue(String name) {
        return Optaional.ofNullable(storageMap.get(storageName)).map(Storage::getValue)
    }

    public void addObserver(String storageName, Runnable observerFunction) {
        observers.add(eventName -> {
            if (eventName.equals(storageName)) {
                observerFunction.run();
            }
        });
    }

    public void notifyObservers(String eventName) {
        observers.forEach(observer -> observer.accept(eventName));
    }
}

public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        mediator.setValue("bob", "yes");
        mediator.setValue("aclie", "no");

        mediator.addObserver("bob", () -> {
            System.out.println("new age for bob:" + mediator.getValue("bob").orElseThrow(RuntimeException::new)))
        });
    }
}
```

## 備忘錄模式(Memento Pattern)

- 將「保持關鍵對象狀態」與關鍵對象的邏輯分開：儲存系統關鍵對象的重要狀態、維護關鍵對象的封裝(不讓人任意訪問)
- 實現備忘錄模式
    - 序列化(serialization)
    - 類別
    - 透過代理而存取的類別
在同一包中聲明的類。
還可以通過代理來訪問該對象，該代理可以在該對像上實現任何保存/還原操作。
- 優點：將儲存的狀態(Memento)對象放在外面，和關鍵對象分開，幫助維持內句
    - 並提供了關鍵對象的狀態封裝
    - 提供恢復能力
- 常用在儲存狀態
- 缺點：儲存和恢復狀態的過程可能相當耗時

```java

public class Client {
    public static void main(String[] args) {
        MasterObject masterObject = new masterObject(); //關鍵對象
        Memento saved = mementoObject.getCurrentState();
        mementoOBject.restoreState(saved);
    }
}

public class MasterObject {
    private final Memento state;

    public Memento getCurrentState() {
        return state;
    }

    public void restoreState(Memento state) {
        this.state = state;
    }
}

public class Memento {
    private static String savedState;

    public Memento(String state) {
        savedState = state;
    }

    public String getState() {
        return savedState;
    }
}

```

```java
//https://en.wikipedia.org/wiki/Memento_pattern

import java.util.ArrayList;
class Originator {
    private String state;

    public void set(String state) {
        this.state = state;
    }

    public Memento saveToMemento() {
        //維基百科的例子中將Memento和Originator綁定在一起
        //產生備忘錄
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
    }

    //維基百科的例子中將Memento和Originator綁定在一起
    public static class Memento {
        private final String state;

        public Memento(String stateToSave) {
            state = stateToSave;
        }

        private String getSavedState() {
            return state;
        }
    }
}

class Caretaker {
    public static void main(String[] args) {
        ArrayList<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();

        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());
        originator.set("State3");
        // We can request multiple mementos, and choose which one to roll back to.
        savedStates.add(originator.saveToMemento());
        originator.set("State4");

        originator.restoreFromMemento(savedStates.get(1));
    }
}
```

## 原形模式 (Prototype Pattern)

- 通過「複製」現有的實例來創造新的實例：不是新建實例，而是複製已經存在的實例
    - 反序列化
    - Java 的 Cloneable
- 這牽涉到程式語言如何實作「複製實例」，參考: https://en.wikipedia.org/wiki/Object_copying
- 使用者可以在不知道實例化何種特定類別的情況下創造新的實例
- 優點：隱藏了創造新實例的複雜性、使用者能夠產生未知對象、在某些情況下複製對象比創建新對象更有效
- 缺點：對象的複製有時很複雜
- 用途：在複雜的類別層次關係中，如果系統必須從中創建新對象，可以考慮以原型模式的方式創造

```java

public interface Prototype {

}

public class ConreteType1 implements Prototype {

}

public class ConcreteType2 implements Prototype {

}

public class PrototypeRegistry {
    public Prototype getPrototype() {
        return correctPrototype.clone();
    }
}

public class Client {
    public static void main(String[] args) {
        //...
        Prototype = PrototypeRegistry.getPrototype();
    }
}


```

## 訪問者模式 (Visitor Pattern)

- 訪問者拜訪組合內的每個元素：通過 Traverser 對象來收集組合中所有對象的狀態，一但收集完狀態，就可以讓訪問者對狀態進行各種操作
    - 當需要新的功能時，只需要修改訪問者即可
- 優點：允許對組合結構加入新的操作而不需改變結構本身、訪問者所進行的操作都集中在一起，想加入新的操作相對容易
- 缺點：Traverser 會和組合結構交互，改變組合結構相對困難、訪問者模式會打破組合結構的封裝

```java

import java.util.ArrayList;

public class Menu {
    protected ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    public void getState(Visitor v) {
        v.visit(this);
    }
}

public class MenuComponent {
    protected ArrayList<Ingredient> componentIngredients = new ArrayList<Ingredient>();
    public void getState(Visitor v) {
        v.visit(this);
    }
}

public class Ingredient {
    public void getState(Visitor v) {
        v.visit(this);
    }
}

public class Visitor() {
    private String ingredientInfo;
    private String menuComponentInfo;
    private STring menuInfo;
    public void visit(Ingredient ingredient) {
        //...get ingredient info
    }
    public void visit(MenuComponent menuComponent) {
        //...get menu component info
    }
    public void visit(Menu menu) {
        //..get menu info
    }
}

public class Traverser {
    private Menu menu;
    private Visitor visitor = new Visitor();
    public void getHealthRating() {
        menu = new Menu();
        menu.getState(visitor);
    }
    public void getCalories() {
        //..
    }
    public void getProtein() {
        //...
    }
    public void getCarbs() {

    }
}
```
