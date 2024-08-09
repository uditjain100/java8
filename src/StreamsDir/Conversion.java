package StreamsDir;

import java.util.*;
import java.util.stream.*;

public class Conversion {
    public static void main(String[] args) {

        // Array to List
        int[] ar = new int[] { 1, 2, 3 };
        List<Integer> bl = Arrays.stream(ar).boxed().collect(Collectors.toList());
        System.out.println(bl);

        // List to Array
        List<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] br = al.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(br));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        // Map/Set to Stream
        System.out.println(map.entrySet().stream());
        System.out.println(map.keySet().stream());
        System.out.println(map.values().stream());

        // Stream to Map
        System.out
                .println(map.entrySet().stream().collect(Collectors.toMap(ele -> ele.getKey(), ele -> ele.getValue())));

        // Flattering a map
        map.entrySet().stream().flatMap(ele -> Stream.of(ele)).forEach(System.out::println);

        // Stream to Set
        System.out.println(map.keySet().stream().collect(Collectors.toSet()));
        System.out.println(map.values().stream().collect(Collectors.toSet()));

        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list = Arrays.asList(12, 3, 4, 5, 6, 1, 2, 88, 45);

        // Array to Stream
        System.out.println(Arrays.stream(arr));
        System.out.println(Stream.of(arr));
        System.out.println(IntStream.of(arr));
        System.out.println(list.stream());

        // Stream to Array
        System.out.println(Arrays.stream(arr).toArray());
        System.out.println(Stream.of(arr).toArray());
        // System.out.println(Arrays.stream(arr).toArray(Object[]::new));
        System.out.println(Stream.of(arr).toArray(Object[]::new));
        System.out.println(Arrays.stream(arr).boxed().mapToInt(Integer::intValue));

        // Slice of a stream
        System.out.println(list.stream().skip(1).limit(2).collect(Collectors.toList()));
        System.out.println(list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> l.stream().skip(1).limit(2))));

        // Getting the first element
        System.out.println(list.stream().reduce((a, b) -> a).get());
        System.out.println(list.stream().findFirst().orElse(-1));

        // Getting the Random element
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findAny().get());

        // Getting the Last element
        System.out.println(list.stream().reduce((a, b) -> b).get());
        System.out.println(list.stream().skip(list.stream().count() - 1).findFirst().get());

    }
}
