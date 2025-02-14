import java.util.Scanner;
import zoo.Veterinary;
import zoo.Zoo;

public class Main {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        container.register(Scanner.class, () -> new Scanner(System.in));
        container.register(Veterinary.class, Veterinary::new);
        container.register(Zoo.class, () -> new Zoo(container.resolve(Veterinary.class)));
        container.register(ZooApplication.class, () -> new ZooApplication(
                container.resolve(Zoo.class),
                container.resolve(Scanner.class)
        ));
        ZooApplication app = container.resolve(ZooApplication.class);
        app.run();
    }
}

