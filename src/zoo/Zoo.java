package zoo;

import animal.Animal;
import animal.Herbo;
import thing.Thing;
import zoo.Veterinary;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();
    private List<Thing> inventory = new ArrayList<>();
    private Veterinary vetClinic;

    public Zoo(Veterinary vetClinic) {
        this.vetClinic = vetClinic;
    }

    public void addAnimal(Animal animal) {
        if (vetClinic.HealthCheck(animal)) {
            animals.add(animal);
            System.out.println(animal.getName() + " принят в зоопарк.");
        } else {
            System.out.println(animal.getName() + " не принят в зоопарк (болен).\n");
        }
    }

    public void addThing(Thing thing) {
        inventory.add(thing);
    }

    public void printFoodConsumption() {
        int totalFood = animals.stream().mapToInt(Animal::getFood).sum();
        System.out.println("Общее количество еды, необходимое животным: " + totalFood + " кг/день");
    }

    public void printFriendlyAnimals() {
        System.out.println("Животные, подходящие для контактного зоопарка:");
        animals.stream()
                .filter(a -> a instanceof Herbo && ((Herbo) a).isFriendly())
                .forEach(a -> System.out.println(a.getName()));
    }

    public void printInventory() {
        System.out.println("Инвентарь зоопарка:");
        inventory.forEach(i -> System.out.println(i.getName() + " - ID: " + i.getNumber()));
    }
}