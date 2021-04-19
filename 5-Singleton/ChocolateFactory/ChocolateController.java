public class ChocolateController {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i<100;i++) {
                System.out.print("1 ");
                ChocolateBoiler boiler = ChocolateBoiler.getInstance();
                System.out.print("1 ");
                boiler.fill();
                System.out.print("1 ");
                boiler.boil();
                System.out.print("1 ");
                boiler.drain();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 1; i<100;i++) {
                System.out.print("2 ");
                ChocolateBoiler boiler = ChocolateBoiler.getInstance();
                System.out.print("2 ");
                boiler.fill();
                System.out.print("2 ");
                boiler.boil();
                System.out.print("2 ");
                boiler.drain();
            }
        });
        thread1.start();
        thread2.start();
    }
}
