package Items;

public class Weapon extends Item {
    //variablar för item stats
    protected int dmg;
    protected int crit;
    protected int useTime;

    //konstrukor för Weapon-klassen
    public Weapon(int weight, String name) {
        super(weight, name);
    }
    //getter för item namn
    public static String getName() {
        return name;
    }
}
