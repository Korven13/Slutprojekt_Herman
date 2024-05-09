package Items;

public class Weapon extends Item {
    protected int dmg;
    protected int crit;
    protected int useTime;


    public Weapon(int weight, String name) {
        super(weight, name);
    }
    public static String getName() {
        return name;
    }
}
