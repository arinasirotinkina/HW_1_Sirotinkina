package animal;
import interfaces.IAlive;
import interfaces.IInventory;

public abstract class Animal implements IAlive, IInventory {
    protected String name;
    protected int food;
    protected int inventoryNumber;

    public Animal(String name, int food, int inventoryNumber) {
        this.name = name;
        this.food = food;
        this.inventoryNumber = inventoryNumber;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public int getNumber() {
        return inventoryNumber;
    }

    public String getName() {
        return name;
    }
}
