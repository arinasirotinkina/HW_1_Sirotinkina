import animal.Monkey;
import animal.Rabbit;
import animal.Tiger;
import animal.Wolf;
import thing.Computer;
import thing.Table;
import zoo.Veterinary;
import zoo.Zoo;

public class Main {
    public static void main(String[] args) {
        Veterinary vetClinic = new Veterinary();
        Zoo zoo = new Zoo(vetClinic);

        // Добавление животных
        zoo.addAnimal(new Monkey("ddd", 2, 5, 5));
        zoo.addAnimal(new Rabbit("ddd", 2, 6, 5));
        zoo.addAnimal(new Tiger("ddd", 2, 7));
        zoo.addAnimal(new Wolf("ddd", 2, 8));

        // Добавление вещей
        zoo.addThing(new Table("jjj", 99));
        zoo.addThing(new Computer("j", 102));

        // Вывод отчетов
        zoo.printFoodConsumption();
        zoo.printFriendlyAnimals();
        zoo.printInventory();
    }
}