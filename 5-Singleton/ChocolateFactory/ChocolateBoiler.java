import java.util.concurrent.locks.*;

public class ChocolateBoiler {
    private ReentrantLock lock = new ReentrantLock();
    private Boolean empty;
    private Boolean boiled;
    private static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }
    public static ChocolateBoiler getInstance() {
        // java can use lock in staic method: lock is a interface and lock() is non-static
        // ref: https://en.wikipedia.org/wiki/Double-checked_locking
        if(uniqueInstance == null) {
            synchronized(ChocolateBoiler.class) {
                if(uniqueInstance == null) {
                    System.out.println("create new uniqueInstance.");
                    uniqueInstance = new ChocolateBoiler();
                }
            }
        }
        System.out.println("return uniqueInstance.");
        return uniqueInstance;
    }
    public void fill() {
        if(isEmpty()) {
            System.out.println("fill");
            empty = false;
            boiled = false;
        }
    }
    public void drain() {
        if(!isEmpty() && isBoiled()) {
            System.out.println("drain");
            empty = true;
        }
    }
    public void boil() {
        if(!isEmpty() && !isBoiled()) {
            System.out.println("boil");
            boiled = true;
        }
    }
    public boolean isEmpty() {
        return empty;
    }
    public boolean isBoiled() {
        return boiled;
    }
}
