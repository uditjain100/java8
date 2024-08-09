package Interfaces.FunctionalInterfaces;

import java.util.function.*;

public class All {
    public static void main(String[] args) {
        Consumer<Integer> consumer = num -> System.out.println(num);
        Predicate<Integer> predicate = num -> num < 5;
        Function<Integer, Integer> function = num -> 4;
        Supplier<Integer> supplier = () -> 3;

        if (predicate.test(supplier.get()))
            consumer.accept(function.apply(supplier.get()));
    }
}
