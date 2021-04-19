# 迭代器模式

- 迭代器模式依賴一個名為「迭代器」的介面：讓各種對象「集合」(collection, aggregation)實現迭代器
    - 利用迭代器封裝「遍歷集合內每個對象的過程」
    - 藉由封裝對象，我們就可以只對實作Iterator介面者使用統一的方法(next(), hasNext())來遍歷
- 迭代器模式提供一種方法訪問一個具聚合對象中的各種元素，又不暴露其內部的表示
    - 迭代器模式將在遍歷元素的責任交給迭代器而不是元素的聚合對象，從而讓我們能更簡單釐清責任

- 迭代器分為外部以及內部
    - 「外部」：客戶使用迭代器的方法next()來控制迭代器
    - 內部迭代器自行運作，客戶無法操作

```java
public interface Iterator {
    public boolean hasNext();
    public Object next();
    public void remove();
}
public class ConcreateIterator implements Iterator {
    protected ConcreteAggregate concreateAggregate;
    //實作如何遍歷某個對象
}

public interface Aggregate {
    //將集合對象以介面概括起來
    public Iterator createIterator();
}

public class ConcreteAggregate implements Aggregate {
    //一個集合
}
```

# 廚師的故事

(書中是服務生的故事，但很怪XD)

- 西式和中式餐館要合辦宴會，但他們的食譜是用不同的術語寫成的，宴會的廚師得會解讀這兩種食譜並根據宴會菜單找出要做的菜並做出來
- 我們不要讓每位廚師學會解讀兩份不同的食譜，而是藉由一個「翻譯機」幫助他們將食譜集合解讀

# 單一責任

- 內聚(cohesion)是用來度量程式碼塊實作與單一功能緊密相關
- 程式碼具有高內聚=一個模組或是一個類被設計為只支持一組相關的功能
- ***單一責任設計原則：一個類應該只有一個引起變化的原因***

# Java的Collection

- java.util.Collection中的類別都實作了java.util.Iterator，從而實現了類別推斷遍歷

```java
for (Object obj: collection) {
//...
}
```
