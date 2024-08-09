package Interfaces.FunctionalInterfaces;

import java.util.function.*;

public class PredicateInterface {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isGreaterThan5 = num -> num > 5;
        Predicate<Integer> isEqualTo5 = Predicate.isEqual(5);

        System.out.println(isEven.test(25));
        System.out.println(isEven.and(isGreaterThan5).test(26));
        System.out.println(isEven.or(isGreaterThan5).test(26));
        System.out.println(isEven.negate().test(25));
        System.out.println(isEqualTo5.test(5));
        System.out.println(isEqualTo5.test(6));

        BiPredicate<Integer, Integer> areEven = (a, b) -> ((a & 1) == 0) && ((b & 1) == 0);
        BiPredicate<Integer, Integer> areGreaterThan5 = (a, b) -> a > 5 && b > 5;

        System.out.println(areEven.test(20, 30));
        System.out.println(areEven.and(areGreaterThan5).test(20, 30));
        System.out.println(areEven.or(areGreaterThan5).test(20, 30));
        System.out.println(areEven.negate().test(20, 30));

        IntPredicate isEvenInt = num -> num % 2 == 0;
        IntPredicate isGreaterThan5Int = num -> num > 5;
        System.out.println(isEvenInt.test(25));
        System.out.println(isEvenInt.and(isGreaterThan5Int).test(26));
        System.out.println(isEvenInt.or(isGreaterThan5Int).test(26));
        System.out.println(isEvenInt.negate().test(25));

        DoublePredicate isEvenDouble = num -> num % 2 == 0;
        LongPredicate isEvenLong = num -> num % 2 == 0;

        // No TriPredicate ot QuadPredicate
    }
}
