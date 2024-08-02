package StreamsDir;

import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Terminal {

    int a;
    String b;

    public Terminal(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) throws Exception {
        // Array to List
        int[] ar = new int[] { 1, 2, 3 };
        List<Integer> bl = Arrays.stream(ar).boxed().collect(Collectors.toList());
        System.out.println(bl);

        // List to Array
        List<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] br = al.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(br));

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5));

        // Printing distinct elements
        list.stream().distinct().forEach((ele) -> System.out.println("-> " + ele));
        list.stream().sorted().forEach((ele) -> System.out.println(": " + ele));

        // sorted() only work with comparable objects
        Arrays.asList(new Terminal(25, "A"), new Terminal(24, "B"), new Terminal(23, "C")).stream()
                .sorted((i, j) -> i.a - j.a)
                .forEach((ele) -> System.out.println(": " + ele));
        Arrays.asList(new Terminal(25, "A"), new Terminal(24, "B"), new Terminal(23, "C")).stream()
                .sorted(Comparator.comparing(ele -> ele.a))
                .forEach((ele) -> System.out.println(": " + ele));

        // Map and Flat map
        list.stream().map(ele -> ele * ele * ele).forEach(System.out::println);

        List<List<Integer>> arrList = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(1, 2))));
        arrList.stream().flatMap(ele -> ele.stream()).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println(
                Stream.of(new String[] { "1", "2" }, new String[] { "3", "4" }).flatMap(Arrays::stream));

        // Filter method
        String[] arr = { "a0", "a1", "a2", "a3", "a4", "a5", "a6", "b1", "b2", "b3", "b4" };

        System.out.println(Arrays.stream(arr).filter((str) -> str.startsWith("a")).collect(Collectors.toList()));
        Stream.of(arr).filter(str -> str.startsWith("a")).forEach(System.out::println);

        AtomicInteger i = new AtomicInteger(0);
        Arrays.stream(arr).filter(str -> i.getAndIncrement() % 2 == 0).forEach(System.out::println);

        IntStream.range(0, arr.length).filter(index -> index % 2 == 0).mapToObj(index -> arr[index])
                .forEach(System.out::println);

        Stream.of(new Terminal[] { new Terminal(16, "A"), new Terminal(25, "B"), new Terminal(30, "C") })
                .filter(obj -> obj.a > 20).forEach(obj -> System.out.println(obj.b));

        System.out.println("Even numbers in the list : " + list.stream().filter((ele) -> ele % 2 == 0).count());

        // Integer List
        System.out.println(list.stream().min((a, b) -> a - b).get());
        // Object Array
        System.out.println(Arrays.stream(list.toArray()).min((a, b) -> (int) a - (int) b).get());
        // Integer Array
        System.out.println(Arrays.stream(new int[] { 5, 4, 2, 3, 4, 5, 6, 8 }).min().getAsInt());

        System.out.println("noneMatch : " + list.stream().noneMatch(ele -> ele > 15));
        System.out.println("allMatch : " + list.stream().allMatch(ele -> ele < 10));
        System.out.println("anyMatch : " + list.stream().anyMatch(ele -> ele > 5));

        // Reduce Method
        System.out.println(list.stream().reduce((a, b) -> a + b).get());

        // Filtering Odd numbers using reduce method
        list.stream().reduce(new ArrayList<>(), (a, b) -> {
            System.out.println("a and b - " + a + " : " + b);
            if ((b & 1) != 0)
                a.add(b);
            return a;
        }, (a, b) -> {
            // System.out.println("a and b : " + a + " : " + b);
            // a.addAll(b);
            return a;
        }).forEach(System.out::println);

        // File Operations on stream
        Stream<String> lines = Files.lines(Paths.get("C://Users//ccs//Documents//java8//src//StreamsDir//File.txt"));
        List<String> list2 = lines.map((str) -> str.toUpperCase()).collect(Collectors.toList());

        list2.forEach((str) -> System.out.println(str));

        PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(Paths.get("C://Users//ccs//Documents//java8//src//StreamsDir//File.txt")));

        Stream.ofNullable(list2).forEach((str) -> System.out.println(str));
        Stream.ofNullable(list2).forEach(pw::println);
        lines.close();

        // Parallel Stream
        list.parallelStream().forEach(System.out::println); // not guarantee ordering
        list.parallelStream().forEachOrdered(System.out::println); // for ordered printing

        // Iterating over a stream
        Stream<Integer> st = new ArrayList<>(Arrays.asList(25, 26, 27, 28)).stream();
        Iterator<Integer> it = st.iterator();
        while (it.hasNext())
            System.out.println("it.next() : " + it.next());

        // Stream Creation
        Stream<Integer> stream0 = Stream.empty();
        Stream<Object> stream1 = Stream.builder().add(1).add(2).add(55).build();

        Stream<ArrayList<Integer>> stream2 = Stream.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        Stream<Integer> stream3 = new ArrayList<>(Arrays.asList(5, 4, 6, 4, 5, 6)).stream();

        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4, 5);

        // Similarly for LongStream, DoubleStream
        IntStream stream7 = IntStream.of(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        IntStream stream8 = IntStream.of(1, 2, 3, 4, 5, 6);
        IntStream stream9 = IntStream.range(0, 10);

        Stream<int[]> stream5 = Stream.of(new int[] { 1, 1, 1, 1, 1, 1 });
        IntStream stream6 = Arrays.stream(new int[] { 2, 2, 2, 2, 2, 2, 2 });

        // Infinite Stream
        Stream<Integer> stream10 = Stream.iterate(0, n -> n + 1).limit(15);
        Stream<Double> stream11 = Stream.generate(Math::random).limit(10);

        // Using Iterator and Iterable
        Stream<Integer> stream12 = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(Arrays.asList(1, 2, 3).iterator(), Spliterator.NONNULL), false);
        Stream<Integer> stream13 = StreamSupport.stream(Arrays.asList(1, 2, 3).spliterator(), false);

    }
}