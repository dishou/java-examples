package tools;

import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class NullChecker {

    public static <T> T get(Supplier<T> supplier, T defaultValue) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }
}
