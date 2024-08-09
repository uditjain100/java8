package Interfaces.FunctionalInterfaces;

import java.util.function.*;

public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<Integer> consumer1 = num -> System.out.println("Consumer 1 Interface : " + num);
        Consumer<Integer> consumer2 = num -> System.out.println("Consumer 2 Interface : " + num * 2);
        consumer1.accept(25);
        consumer2.accept(25);

        consumer1.andThen(consumer2).accept(25);
        consumer2.andThen(consumer1).accept(25);

        BiConsumer<Integer, String> biConsumer1 = (num, str) -> System.out
                .println("BiConsumer 1 Interface : " + num + ", " + str);
        BiConsumer<Integer, String> biConsumer2 = (num, str) -> System.out
                .println("BiConsumer 2 Interface : " + (num * 2) + ", " + str);

        biConsumer1.accept(25, "A");
        biConsumer2.accept(25, "A");
        biConsumer1.andThen(biConsumer2).accept(25, "A");
        biConsumer2.andThen(biConsumer1).accept(25, "A");
    }
}
