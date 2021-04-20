# 觀察者模式

- ***觀察者模式：在對象之間定義一一對多的關係，當一個對象改變狀態，依賴他的對象都會收到通知並自動更新***
- 觀察者模式有推或拉，但推被認為比較正確(?)
- 有多個觀察者時，不可以依賴特定的通知次序

```java

public interface Observer {
    public void update();
}

public class ConcreteObserver implements Observer {
    public void update() {

    }
}

public interface Subject {
    public void registerObserver();
    public void removeObserver();
    public void notifyObserver();
}

public class ConcreteSubject implements Subject {
    private ArrayList<Observer> observers;
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver() {
        observers.remove(o);
    }
    public void notifyObserver() {

    }
    public Object getState() {

    }
    public void setState() {

    }
}


```

# 設計原則

- java的observable 是一個class，又java不允許多重繼承，使observable無法以interface的方式實作自己的「真正實現」，不能搭配使用
- 針對介面編程，而不是實作本身
