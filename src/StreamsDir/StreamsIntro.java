package StreamsDir;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StreamsIntro {
        public static void main(String[] args) throws Exception, IOException {
                // Parallel Stream
                List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5));
                list.parallelStream().forEach(System.out::print); // not guarantee ordering
                System.out.println();
                list.parallelStream().forEachOrdered(System.out::print); // for ordered printing
                System.out.println();

                // Stream Builder
                System.out.println(Stream.<String>builder().add("20").add("200").build().collect(Collectors.toList()));
                Stream.<String>builder().add("50").andThen(ele -> System.out.println(ele)).accept("82");

                // Stream Support - LongStream / IntStream / DoubleStream
                LongStream longStream = LongStream.of(10);
                System.out.println(longStream);
                System.out.println(LongStream.of(1, 2, 3, 4, 5, 6, 7, 8));
                System.out.println(LongStream.empty()); // Returns an empty sequential LongStream
                System.out.println(LongStream.range(1, 10));
                System.out.println(LongStream.rangeClosed(1, 10));
                System.out.println(LongStream.builder().add(10).add(20).build());
                System.out.println(LongStream.concat(LongStream.of(10), LongStream.of(20, 30, 40)));
                System.out.println(LongStream.iterate(0, i -> i + 1).limit(10));
                System.out.println(LongStream.iterate(0, i -> i < 10, i -> i + 1));
                System.out.println(LongStream.generate(() -> (long) Math.random()).limit(50));

                IntStream intStream = IntStream.of(1, 2, 44, 555);
                DoubleStream doubleStream = DoubleStream.of(10.0); // No range or rangeClosed method

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

                // Iterating over a stream
                Stream<Integer> st = new ArrayList<>(Arrays.asList(25, 26, 27, 28)).stream();
                Iterator<Integer> it = st.iterator();
                while (it.hasNext())
                        System.out.println("it.next() : " + it.next());

                // Reverse elements of a Stream
                System.out.println(
                                list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                                        Collections.reverse(l);
                                        return l.stream();
                                })).collect(Collectors.toList()));

                list.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
                                .forEachRemaining(System.out::println);

        }
}
