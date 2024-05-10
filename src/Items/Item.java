package Items;

public class Item {
    //variabler för item attributer
    protected int weight;
    protected static String name;

    //konstruktor för Item-klassen
    public Item(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    //getter för item namn
    public static String getName() {
        return name;
    }
}
