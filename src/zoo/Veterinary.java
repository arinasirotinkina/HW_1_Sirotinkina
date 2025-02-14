package zoo;

import animal.Animal;

import java.util.Random;

public class Veterinary {
    boolean HealthCheck(Animal animal) {
        return new Random().nextDouble() < 0.7;
    }
}
