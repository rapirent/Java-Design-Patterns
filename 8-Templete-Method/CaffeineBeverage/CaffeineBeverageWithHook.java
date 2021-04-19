public abstract class CaffeineBeverageWithHook {
    public final void prepareRecipe() {
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

