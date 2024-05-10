package Items;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {
    private List<T> items;  //lista för föremålen i inventory

    //konstruktor för inventory-klassen
    public Inventory() {
        this.items = new ArrayList<>();
    }

    //lägger till föremål i invetory-listan
    public void addItem(T item) {
        items.add(item);
    }

    //tar bor föremål från inventory-listan
    public void removeItem(T item) {
        items.remove(item);
    }

    //getter för alla föremål i inventory
    public List<T> getItems() {
        return items;
    }

    //printar alla föremål i inventory
    public void printInvetory() {
        System.out.println("Inventory: ");
        //loopar igenom alla föremål i inventory och printar
        for (T item : items) {
            System.out.println(item.toString());
        }
    }

}
