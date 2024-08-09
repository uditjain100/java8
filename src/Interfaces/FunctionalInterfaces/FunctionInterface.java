package Interfaces.FunctionalInterfaces;

import java.util.function.*;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleIt = num -> num * 2;
        Function<String, Integer> parseToInt = Integer::parseInt;

        System.out.println(doubleIt.apply(5));
        System.out.println(parseToInt.apply("555"));
        System.out.println(parseToInt.andThen(doubleIt).apply("55"));
        System.out.println(doubleIt.compose(parseToInt).apply("55"));
        System.out.println(Function.identity().apply(525));

        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println(multiply.apply(5, 10));
        System.out.println(add.apply(5, 10));
        System.out.println(multiply.andThen(doubleIt).apply(10, 20));
        System.out.println(add.andThen(doubleIt).apply(10, 20));

        // "Integer" -> it is return type
        IntFunction<Integer> add5 = num -> num + 5;
        IntFunction<Integer> multiply10 = num -> num * 10;
        System.out.println(add5.apply(54));
        System.out.println(multiply10.apply(54));

        LongFunction<Integer> multiply11 = num -> (int) num * 11;
        DoubleFunction<Integer> multiply12 = num -> (int) num * 12;

        // Works as Function<Integer, Integer>
        UnaryOperator<Integer> multiply13 = num -> (int) num * 13;
        System.out.println(multiply13.apply(20));
        System.out.println(multiply13.andThen(doubleIt).apply(22));
        System.out.println(multiply13.compose(doubleIt).apply(22));

        // Works as BiFunction<Integer, Integer, Integer>
        BinaryOperator<Integer> add25 = (a, b) -> a + b + 25;
        System.out.println(add25.apply(20, 30));
        System.out.println(add25.andThen(doubleIt).apply(22, 50));
    }
}
