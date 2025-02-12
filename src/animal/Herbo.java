package animal;

import animal.Animal;

public abstract class Herbo extends Animal {
    int kindness;

    public Herbo(String name, int food, int inventoryNumber, int kindness) {
        super(name, food, inventoryNumber);
        this.kindness = kindness;
    }

    public boolean isFriendly() {
        return kindness > 5;
    }
}
