package animal;

import animal.Herbo;

public class Rabbit extends Herbo {
    public Rabbit(String name, int food, int inventoryNumber, int kindness) {
        super(name, food, inventoryNumber, kindness);
    }
    @Override
    public String toString() {
        return inventoryNumber + "\tКролик" + "\t" + name + "\t" + food;
    }
}
