package zoo;

import animal.Animal;
import animal.Herbo;
import thing.Thing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();
    private List<Thing> things = new ArrayList<>();
    private Veterinary vet;

    public Zoo(Veterinary vet) {
        this.vet = vet;
    }

    public boolean addAnimal(Animal animal) {
        if (vet.HealthCheck(animal)) {
            animals.add(animal);
            return true;
        } else {
            return false;
        }
    }

    public void addThing(Thing thing) {
        things.add(thing);
    }

    public int getFoodSum() {
        return animals.stream().mapToInt(Animal::getFood).sum();
    }

    public Stream<Animal> getFriendlyAnimals() {
        return animals.stream().filter(a -> a instanceof Herbo && ((Herbo) a).isFriendly());
    }

    public List<Thing> getThings() {
        return things;
    }
    public List<Animal> getAnimals() {
        return animals;
    }

    public int getAnimalsNumber() {
        return animals.size();
    }
    public int getThingsNumber() {
        return things.size();
    }
}