package thing;
import interfaces.IInventory;

public class Thing implements IInventory {
    protected String name;
    protected int inventoryNumber;

    public Thing(String name, int inventoryNumber) {
        this.name = name;
        this.inventoryNumber = inventoryNumber;
    }

    @Override
    public int getNumber() {
        return inventoryNumber;
    }

    public String getName() {
        return name;
    }
}