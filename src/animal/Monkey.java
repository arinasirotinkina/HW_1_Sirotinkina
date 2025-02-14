package animal;

import animal.Herbo;

public class Monkey extends Herbo {
    public Monkey(String name, int food, int inventoryNumber, int kindness) {
        super(name, food, inventoryNumber, kindness);
    }
    @Override
    public String toString() {
        return inventoryNumber + "\tОбезьяна" + "\t" + name + "\t" + food;
    }
}
