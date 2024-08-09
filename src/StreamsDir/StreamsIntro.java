package StreamsDir;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StreamsIntro {
    public static void main(String[] args) throws Exception, IOException {
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
        // IntStream.rangeClosed(0, 10); // end Inclusive

        Stream<int[]> stream5 = Stream.of(new int[] { 1, 1, 1, 1, 1, 1 });
        IntStream stream6 = Arrays.stream(new int[] { 2, 2, 2, 2, 2, 2, 2 });

        // Infinite Stream
        Stream<Integer> stream10 = Stream.iterate(0, n -> n + 1).limit(15);
        Stream<Double> stream11 = Stream.generate(Math::random).limit(10);

        // Using Iterator and Iterable
        Stream<Integer> stream12 = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(Arrays.asList(1, 2, 3).iterator(),
                        Spliterator.NONNULL),
                false);
        Stream<Integer> stream13 = StreamSupport.stream(Arrays.asList(1, 2, 3).spliterator(), false);

        // Parallel Stream
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5));
        list.parallelStream().forEach(System.out::println); // not guarantee ordering
        list.parallelStream().forEachOrdered(System.out::println); // for ordered printing

        // File Operations on stream
        Stream<String> lines = Files
                .lines(Paths.get("C://Users//ccs//Documents//java8//src//StreamsDir//File.txt"));
        List<String> list2 = lines.map((str) -> str.toUpperCase()).collect(Collectors.toList());

        list2.forEach((str) -> System.out.println(str));

        // PrintWriter pw = new PrintWriter(
        // Files.newBufferedWriter(Paths
        // .get("C://Users//ccs//Documents//java8//src//StreamsDir//File.txt")));

        // Stream.ofNullable(list2).forEach((str) -> System.out.println(str));
        // Stream.ofNullable(list2).forEach(pw::println);
        lines.close();

        // Read all data from the file except header and footer
        System.out.println(".............................");
        List<String> data = Files
                .readAllLines(Paths.get("C://Users//ccs//Documents//java8//src//StreamsDir//File.txt"));
        data.stream().skip(1).limit(data.size() - 2).forEach(System.out::println);
        System.out.println(".............................");

        // Iterating over a stream
        Stream<Integer> st = new ArrayList<>(Arrays.asList(25, 26, 27, 28)).stream();
        Iterator<Integer> it = st.iterator();
        while (it.hasNext())
            System.out.println("it.next() : " + it.next());

    }
}
