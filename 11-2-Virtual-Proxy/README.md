# 虛擬代理

- 透過創建虛擬代理，讓其代表創建開銷大的對象，虛擬代理延遲該對象的創建，直到我們真正需要一個對象的時候才創建他

## Swing

- awt的Swing ImageIcon 創建開銷很大

```java
//Swing
public interface Icon {
    public getIconWidth();
    public getIconHeight();
    public paintIcon();
}

//Swing
public class ImageIcon implements Icon {
    @Override
    public getIconWidth() {
        //
    }
    @Override
    pubic getIconHeight() {
        //
    }
    @Override
    public paintIcon() {
        //
    }
}
```

- 我們可以藉由 ImageProxy 來管理 ImageIcon

```java
public class ImageProxy implements Icon {
    protected ImageIcon imageIcon;

    @Override
    public getIconWidth() {
        //
    }
    @Override
    pubic getIconHeight() {
        //
    }
    @Override
    public paintIcon() {
        //
    }
}

```
