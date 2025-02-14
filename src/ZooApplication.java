import java.util.List;
import java.util.Scanner;
import thing.Computer;
import thing.Table;
import zoo.Zoo;
import animal.*;
import thing.Thing;

public class ZooApplication {
    private final Zoo zoo;
    private final Scanner scanner;

    public ZooApplication(Zoo zoo, Scanner scanner) {
        this.zoo = zoo;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            int opt = StartMenu(scanner);
            switch (opt) {
                case 1:
                    AddNewAnimal(scanner, zoo);
                    break;
                case 2:
                    PrintAnimals(zoo.getAnimals(),
                            "Животных в зоопарке: " + zoo.getAnimalsNumber());
                    break;
                case 3:
                    PrintAnimals(zoo.getFriendlyAnimals().toList(),
                            "Животных, пригодных для контактного зоопарка: "
                                    + zoo.getFriendlyAnimals().toList().size());
                    break;
                case 4:
                    PrintFood(zoo.getFoodSum());
                    break;
                case 5:
                    AddNewThing(scanner, zoo);
                    break;
                case 6:
                    PrintThings(zoo.getThings(), "Вещей в инвентаре: " + zoo.getThingsNumber());
                    break;
                case 7:
                    return;
            }
        }
    }

    static int StartMenu(Scanner scanner) {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить животное в зоопарк");
        System.out.println("2. Посмотреть список животных");
        System.out.println("3. Посмотреть список животных, которые могут быть отправлены в контактный зоопарк");
        System.out.println("4. Рассчитать суммарное количество еды");
        System.out.println("5. Добавить вещь в инвентарь");
        System.out.println("6. Просмотреть список вещей в инвентаре");
        System.out.println("7. Выход");
        return readInt(scanner, 1, 7);
    }

    static int readInt(Scanner scanner, int minValue, int maxValue) {
        int number;
        while (true) {
            System.out.print("Введите число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number <= maxValue && number >= minValue) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Ошибка: необходимо число от " + minValue + " до " + maxValue);
                }
            } else {
                System.out.println("Ошибка: необходимо целое число");
                scanner.next();
            }
            scanner.nextLine();
        }
        return number;
    }

    public static String readString(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Ошибка: строка не должна быть пустой. Попробуйте снова.");
        }
    }

    static void AddNewAnimal(Scanner scanner, Zoo zoo) {
        int animType = AddAnimalMenu(scanner);
        if (animType == 5) {
            return;
        }
        System.out.print("Введите кличку животного: ");
        String name = readString(scanner);
        int kindness = 0;
        System.out.println("Потребляемое количество еды (в кг) (целое число)");
        int food = readInt(scanner, 0 , 500);
        if (animType == 1 || animType ==  2) {
            System.out.println("Степень доброты животного (целое число от 1 до 10):");
            kindness = readInt(scanner,  1, 10);
        }
        int id = zoo.getAnimalsNumber() + 1;
        switch (animType) {
            case 1:
                PrintAddResult(zoo.addAnimal(new Monkey(name, food, id, kindness)));
                break;
            case 2:
                PrintAddResult(zoo.addAnimal(new Rabbit(name, food, id, kindness)));
                break;
            case 3:
                PrintAddResult(zoo.addAnimal(new Tiger(name, food, id)));
                break;
            case 4:
                PrintAddResult(zoo.addAnimal(new Wolf(name, food, id)));
                break;
        }
    }

    static void PrintAddResult(boolean result) {
        if (result) {
            System.out.println("Животное принято в зоопарк");
        } else {
            System.out.println("Животное не прошло ветеринарную комиссию, не принято в зоопарк");
        }
    }

    static void AddNewThing(Scanner scanner, Zoo zoo) {
        int thingType = AddThingMenu(scanner);
        if (thingType == 3) {
            return;
        }
        System.out.print("Наименование предмета: ");
        String name = readString(scanner);
        int id = zoo.getThingsNumber() + 1;
        switch (thingType) {
            case 1:
                zoo.addThing(new Computer(name, id));
                break;
            case 2:
                zoo.addThing(new Table(name, id));
                break;
        }
        System.out.println("Вещь добавлена в инвентарь");
    }

    static void PrintAnimals(List<Animal> animals, String message) {
        System.out.println(message);
        animals.forEach(a ->
                System.out.println(a.toString()));
    }

    static void PrintThings(List<Thing> things, String message) {
        System.out.println(message);
        things.forEach(a ->
                System.out.println(a.getName() + "\t" + a.getNumber()));
    }

    static void PrintFood(int food) {
        System.out.println("Общее количество еды, необходимое животным: " +
                food + " кг/день");
    }

    static int AddAnimalMenu(Scanner scanner) {
        System.out.println("\nВыберите животное:");
        System.out.println("1. Обезьяна");
        System.out.println("2. Кролик");
        System.out.println("3. Тигр");
        System.out.println("4. Волк");
        System.out.println("5. Назад");
        return readInt(scanner,1, 5);
    }

    static int AddThingMenu(Scanner scanner) {
        System.out.println("\nВыберите вещь:");
        System.out.println("1. Компьютер");
        System.out.println("2. Стол");
        System.out.println("3. Назад");
        return readInt(scanner, 1, 3);
    }
}
