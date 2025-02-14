package animal;

import animal.Predator;

public class Tiger extends Predator {
    public Tiger(String name, int food, int inventoryNumber) {
        super(name, food, inventoryNumber);
    }
    @Override
    public String toString() {
        return inventoryNumber + "\tТигр" + "\t" + name + "\t" + food;
    }
}
