package character;

public abstract class Character {
    WeaponBehavior weaponBehavior;
    public Character() {}
    public void setWeapon(WeaponBehavior w) {
        weaponBehavior = w;
    }
    public void fight() {
        weaponBehavior.useWeapon();
    }
}

