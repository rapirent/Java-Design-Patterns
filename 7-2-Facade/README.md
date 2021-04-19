# 外觀模式

- 外觀模式(facade pattern)簡化介面，提供簡潔的方法：提供一個高層級的介面，讓子系統被統一納入其中
    - 外觀模式通過將子系統組合進外觀介面中，從而將工作委派給子系統執行
    - 裝飾器模式將「新的行為」加入類別中，而不需要修改現有的程式碼：擴展原有的類別，不改變介面但加入更多責任
    - 轉接器模式將一個介面轉換成另外一個介面，提供特定的方法讓客戶使用

```java
//裝飾器
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
//轉接器
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

- 最少知識原則(又稱得墨忒耳定律, Law of Demeter)：只和密友交談，不需要認識其他非必要的對象的組件
    - 在設計系統時，不管是任何對象，都要注意他所交互的類別有哪些，並注意它和這些類如何交互。
    - 不要讓太多類別耦合在一起，在該對象的方法內，我們只應該調用以下範圍的方法：
        1. 該對象本身
        2. 被當作方法參數而傳進來的對象: 如果某對象是調用其他方法的返回結果，則不需要調用該對象的方法
        3. 此方法所創建或實例化的任何對象
        4. 該對象的任何組件
    - 雖然採用最少知識原則可以提高維護性和減少對象依賴，但會造成複雜度增加及性能降低
```java
//未採用最少知識原則
public float getTemp() {
    Thermometer thermometer = station.getThermometer();
    return thermometer.getThermometer();
}
//採用最少知識原則
public float getTemp() {
    return station.getTemperature();
}
```
