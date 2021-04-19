package simplePizzaFactory;
public class PizzaTestDrive {
    public static void main(String[] args) {
        SimplePizzaFactory spf = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(spf);

        Pizza p = store.orderPizza("cheese");
        p = store.orderPizza("veggie");
    }
}
