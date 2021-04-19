# 菜單迭代器的例子

- 延續迭代器模式的例子，如果一份菜單或食譜有「子菜單」、「子食譜」，我們需要一種「層次結構」幫助迭代器遍歷
- 這樣也可以幫助我們將額外邏輯封裝入迭代器中

# 組合模式

- 組合模式(Composite pattern)組合對象成樹狀結構，藉此形成「整體/部分」層次結構，組合模式讓客戶可以以一致的方式處理個別對象以及對象組合
- 組合模式可以讓一些重複的邏輯統一應用在樹狀結構應用中：通過組合模式，我們能把相同的操作應用在組合和個別對象上
    - ***我們可以「忽略」個別對象和對象組合的差別***
- 組合模式有兩種「組件」(Component)：「組合/容器」(Composite)和節點元素(Leaf)
- 組合模式把類型的組合關係轉換成「樹狀關係」
- 組合模式增加了透明性(Transparency)，客戶可以將節點和容器一視同仁(因為我們有抽象組件類型[Component])，而一個組件是節點或容器是完全透明的
    - 間接失去了一些安全性

        ```java

        public class Component {
            public void operation() {
            }
            public void add(Component component) {

            }
            public void remove(Component component) {

            }
            public Component getChild(int index) {

            }
        }

        public class Leaf extends Component {
            @Override
            public void operation() {

            }
        }

        public class Composite extends Component {
            @Override
            public void operation() {
            }
            @Override
            public void add(Component component) {

            }
            @Override
            public void remove(Component component) {

            }
            @Override
            public Component getChild(int index) {

            }
        }
        ```
## 缺點

- 透明性的同時帶來安全性下降
- 為了保持透明性以及「一致的對待方式」，組合內所有組件對象都必須實現相同的介面，這將會導致有些對象具有一些沒意義的方法
- 也可以對不同的對象使用不同的組合介面

## 優點

- 我們可以輕易地整理多個對象的集合，統一的處理，讓組合內的組件各自做出正確的事情
- 客戶可以不必判斷對象集合之間的關係，只需要對整個結構調用方法即可
- 可以盡量讓一個類別只有一個責任

# 空迭代器

- 如果使用`null`就得讓客戶自行檢驗型別或值，而如果實作一個「空」迭代器，客戶將不用再擔心檢查的問題


# Caching

- 有時候遍歷一組合結構的成本太高，就適合對他做快取
