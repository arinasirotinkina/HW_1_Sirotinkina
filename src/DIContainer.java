import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DIContainer {
    private final Map<Class<?>, Supplier<?>> dependencies = new HashMap<>();
    public <T> void register(Class<T> clazz, Supplier<T> supplier) {
        dependencies.put(clazz, supplier);
    }
    public <T> T resolve(Class<T> clazz) {
        Supplier<?> supplier = dependencies.get(clazz);
        if (supplier != null) {
            return (T) supplier.get();
        }
        throw new RuntimeException("Dependency not found: " + clazz);
    }
}
