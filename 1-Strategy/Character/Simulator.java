public class Simulator{
    public static void main(String[] args) {
        Character king = new King();
        king.setWeapon(new SwordBehavior());
        king.fight();

        Character queen = new Queen();
        queen.setWeapon(new KnifeBehavior());
        queen.fight();

        Character knight = new Knight();
        knight.setWeapon(new AxeBehavior());
        knight.fight();

        Character troll = new Troll();
        troll.setWeapon(new BowAndArrowBehavior());
        troll.fight();
    }
}
