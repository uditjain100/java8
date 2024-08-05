package StreamsDir;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.*;

public class DSA {
    public static void main(String[] args) {
        // is Prime
        int n = 37;
        System.out.println("Is Prime : "
                + (IntStream.rangeClosed(2, (int) Math.sqrt(n)).anyMatch(i -> (n % i) == 0) ? false : true));

        // print first count number of primes
        int count = 10;
        System.out.println(Stream.iterate(1, i -> i + 1)
                .filter(i -> i == 1 ? false
                        : i == 2 ? true
                                : IntStream.rangeClosed(2, (int) Math.sqrt(i)).noneMatch(num -> i % num == 0))
                .limit(count).collect(Collectors.toList()));

        String str = "Welcome to Kolkata and Kolkata welcome you";
        System.out.println(Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
