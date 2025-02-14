package animal;

import animal.Predator;

public class Wolf extends Predator {
    public Wolf(String name, int food, int inventoryNumber) {
        super(name, food, inventoryNumber);
    }
    @Override
    public String toString() {
        return inventoryNumber + "\tВолк" + "\t" + name + "\t" + food;
    }
}
