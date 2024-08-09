package StreamsDir;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.atomic.AtomicInteger;

public class IntermediateOperation {
        public static void main(String[] args) {
                String[] arr = { "a0", "a1", "a2", "a3", "a4", "a5", "a6", "b1", "b2", "b3", "b4" };
                List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5));

                // 1. Filter
                // 1.a. Filter by Object Properties
                Arrays.stream(arr).filter((str) -> str.startsWith("a")).collect(Collectors.toList())
                                .forEach(System.out::print);
                System.out.println();

                Stream.of(arr).filter(str -> str.startsWith("a")).forEach(System.out::print);
                System.out.println();

                // 1.b. Filter by Index
                AtomicInteger index = new AtomicInteger(0);
                Arrays.stream(arr).filter(str -> index.getAndIncrement() % 2 == 0).forEach(System.out::print);
                System.out.println();

                IntStream.range(0, arr.length).filter(i -> i % 2 == 0).mapToObj(i -> arr[i])
                                .forEach(System.out::print);
                System.out.println();

                // 1.c. Filter by custom Object Properties
                Stream.of(
                                new Intermediate[] { new Intermediate(16, "A"), new Intermediate(25, "B"),
                                                new Intermediate(30, "C") })
                                .filter(obj -> obj.a > 20).forEach(obj -> System.out.println(obj.b));

                System.out.println("Even numbers in the list : " + list.stream().filter((ele) -> ele % 2 == 0).count());

                // 2. Map
                list.stream().map(ele -> ele * ele * ele).forEach(System.out::print);
                System.out.println();

                // 3. Flat map
                List<List<Integer>> arrList = new ArrayList<>(
                                Arrays.asList(new ArrayList<>(Arrays.asList(1, 2)),
                                                new ArrayList<>(Arrays.asList(1, 2))));
                arrList.stream().flatMap(ele -> ele.stream()).collect(Collectors.toList()).forEach(System.out::print);
                System.out.println();

                System.out.println(
                                Stream.of(new String[] { "1", "2" }, new String[] { "3", "4" })
                                                .flatMap(Arrays::stream).collect(Collectors.toList()));

                // 4. Sorted
                // 4.a. Using Comparable
                list.stream().sorted().forEach(System.out::print);
                System.out.println();

                Arrays.asList(new Intermediate(25, "A"), new Intermediate(24, "B"), new Intermediate(23, "C")).stream()
                                .sorted()
                                .forEach(System.out::print);
                System.out.println();

                // 4.b. Using Comparator
                Arrays.asList(new Intermediate(25, "A"), new Intermediate(24, "B"), new Intermediate(23, "C")).stream()
                                .sorted((i, j) -> i.a - j.a)
                                .forEach(System.out::print);
                System.out.println();

                Arrays.asList(new Intermediate(25, "A"), new Intermediate(24, "B"), new Intermediate(23, "C")).stream()
                                .sorted(Comparator.comparing(ele -> ele.a))
                                .forEach(System.out::print);
                System.out.println();

                // 5. Peek
                list.stream().map(ele -> ele * ele * ele).peek(System.out::print).filter(ele -> ele < 5)
                                .forEach(System.out::print);
                System.out.println();

                // 6. distinct
                System.out.println(list.stream().distinct().collect(Collectors.toList()));

                // 7. Limit and Skip
                // 7.a. limit
                System.out.println(list.stream().limit(3).collect(Collectors.toList()));

                // 7.b skip
                System.out.println(list.stream().skip(3).collect(Collectors.toList()));

                // 7.c skip + limit -> slice of a stream
                System.out.println(list.stream().skip(1).limit(2).collect(Collectors.toList()));
                System.out.println(list.stream()
                                .collect(Collectors.collectingAndThen(Collectors.toList(),
                                                l -> l.stream().skip(1).limit(2))));

                // 8. Concat
                System.out.println(Stream.concat(list.stream(),
                                Arrays.stream(arr)).collect(Collectors.toList()));
                System.out.println(Stream.concat(list.stream(),
                                Stream.concat(list.stream(),
                                                Arrays.stream(arr)))
                                .collect(Collectors.toList()));

                // 9. drop while
                System.out.println(list.stream().dropWhile(ele -> ele > 5).collect(Collectors.toList()));

                // 10. take while
                System.out.println(list.stream().takeWhile(ele -> ele > 5).collect(Collectors.toList()));

        }
}

class Intermediate implements Comparable<Intermediate> {
        int a;
        String b;

        public Intermediate(int a, String b) {
                this.a = a;
                this.b = b;
        }

        @Override
        public int compareTo(Intermediate other) {
                return this.a - other.a;
        }

        @Override
        public String toString() {
                return "Intermediate{" +
                                "a=" + a +
                                ", b='" + b + '\'' +
                                '}';
        }
}
