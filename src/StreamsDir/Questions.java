package StreamsDir;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Questions {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 11, 2, 33, 3, 33, 4, 5, 5, 5, 6, 6, 9);

        // Finding the duplicates
        Set<Integer> set = new HashSet<Integer>();
        System.out.println(list.stream().filter(ele -> !set.add(ele)).collect(Collectors.toSet()));

        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(ele -> ele.getValue() > 1)
                .collect(Collectors.toMap(ele -> ele.getKey(), ele -> ele.getValue())).keySet());

        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(ele -> ele.getValue() > 1).map(ele -> ele.getKey())
                .collect(Collectors.toList()));

        System.out.println(
                list.stream().filter(ele -> Collections.frequency(list, ele) > 1).collect(Collectors.toSet()));

        // Count occurrence of a given character in a string
        String str = "aaa";
        char ch = 'a';
        System.out.println(str.chars().filter(c -> c == ch).count());

        // Reverse elements of a Stream
        System.out.println(
                list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l.stream();
                })).collect(Collectors.toList()));

        list.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
                .forEachRemaining(System.out::println);

        // Initialize a list in a single line with a specified value
        System.out.println(Arrays.stream(new Object[] { (Integer) 2, "abc" }).collect(Collectors.toList()));

        // joining method
        String[] arr = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        System.out.println(Arrays.stream(arr).collect(Collectors.joining()));
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(", ", "[", "]")));

    }
}
