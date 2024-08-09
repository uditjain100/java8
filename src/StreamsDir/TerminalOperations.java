package StreamsDir;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5));
        int[] arr = new int[] { 5, 4, 2, 3, 4, 5, 6, 8 };

        // 1. collect
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toList()));
        System.out.println(list.stream().filter(ele -> ele > 4).collect(Collectors.toSet()));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter(ele -> ele > 4)
                .collect(Collectors.toMap(Function.identity(), ele -> "" + ele)));

        // 1.a. Collectors

        // 2. forEach
        list.parallelStream().forEach(System.out::print); // not guarantee ordering
        System.out.println();

        // 3. forEachOrdered
        list.parallelStream().forEachOrdered(System.out::print); // for ordered printing
        System.out.println();

        // 4. Reduce Method
        System.out.println(list.stream().reduce((a, b) -> a + b).get());

        // 4.b. Filtering Odd numbers using reduce method
        list.stream().reduce(new ArrayList<>(), (a, b) -> {
            // System.out.println("a and b - " + a + " : " + b);
            if ((b & 1) != 0)
                a.add(b);
            return a;
        }, (a, b) -> {
            // System.out.println("a and b : " + a + " : " + b);
            // a.addAll(b);
            return a;
        }).forEach(System.out::print);
        System.out.println();

        // 5. min, max
        // 5.a. Integer List
        System.out.println(list.stream().min((a, b) -> a - b).get());
        // 5.b. Object Array
        System.out.println(Arrays.stream(list.toArray()).min((a, b) -> (int) a - (int) b).get());
        // 5.c. Integer Array
        System.out.println(Arrays.stream(arr).min().getAsInt());

        // 6. sum
        System.out.println(IntStream.range(0, list.size()).map(index -> list.get(index)).sum());

        // 7. count
        System.out.println(list.stream().count());

        // 8. toArray
        System.out.println(list.stream().toArray());

        // 9. anyMatch, allMatch, noneMatch
        System.out.println("anyMatch : " + list.stream().anyMatch(ele -> ele > 5));
        System.out.println("allMatch : " + list.stream().allMatch(ele -> ele < 10));
        System.out.println("noneMatch : " + list.stream().noneMatch(ele -> ele > 15));

        // 10. findAny, findFirst
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findFirst().get());

    }
}
