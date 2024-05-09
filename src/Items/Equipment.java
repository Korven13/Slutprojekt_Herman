package Items;

public class Equipment extends Item{
    private int armor;
    private int hpBonus;

    public Equipment(int weight, String name, int armor, int hpBonus) {
        super(weight, name);
        this.armor = armor;
        this.hpBonus = hpBonus;
    }
    public int getArmor() {
        return armor;
    }
}
