package Items;

public class Equipment extends Item{
    //variabler för stats
    private int armor;
    private int hpBonus;

    //konstruktor för Equipment
    public Equipment(int weight, String name, int armor, int hpBonus) {
        super(weight, name);
        this.armor = armor;
        this.hpBonus = hpBonus;
    }
    //getter för armor stat
    public int getArmor() {
        return armor;
    }
    //getter för bonus hp stat
    public int getHpBonus() {
        return hpBonus;
    }
}
