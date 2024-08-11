package OptionalDir;

import java.util.*;

public class OptionalTester {

    public static void main(String[] args) {
        String[] arr = new String[3];
        arr[0] = "000";

        Optional<String> o1 = Optional.empty(); // o1 is set to empty instance of Optional class
        Optional<String> o2 = Optional.of(arr[0]); // if arr[0] is null then java.lang.NullPointerException
        Optional<String> o3 = Optional.ofNullable(arr[1]); // if arr[1] is null then o3 is set to Empty Optional object

        // Note : In any of the following methods if o1/o2/o3 is null then they will
        // give java.lang.NullPointerException

        System.out.println("o1 : " + o1);
        System.out.println("o2 : " + o2);
        System.out.println("o3 : " + o3);

        System.out.println("o1.isEmpty() : " + o1.isEmpty());
        System.out.println("o2.isEmpty() : " + o2.isEmpty());
        System.out.println("o3.isEmpty() : " + o3.isEmpty());

        System.out.println("o1.get() : " + (!o1.isEmpty() ? o1.get() : -1)); // otherwise
                                                                             // java.util.NoSuchElementException
        System.out.println("o2.get() : " + (!o2.isEmpty() ? o2.get() : -1)); // otherwise
                                                                             // java.util.NoSuchElementException
        System.out.println("o3.get() : " + (!o3.isEmpty() ? o3.get() : -1)); // otherwise
                                                                             // java.util.NoSuchElementException

        // equals compares internal value of one optional object to another
        System.out.println("o1.equals empty : " + o1.equals(Optional.empty()));
        System.out.println("o1.equals of : " + o1.equals(Optional.of("000")));
        System.out.println("o1.equals ofNullable : " + o1.equals(Optional.of(arr[0])));

        System.out.println("o2.equals empty : " + o2.equals(Optional.empty()));
        System.out.println("o2.equals of : " + o2.equals(Optional.of("000")));
        System.out.println("o2.equals ofNullable : " + o2.equals(Optional.of(arr[0])));

        System.out.println("o3.equals empty : " + o3.equals(Optional.empty()));
        System.out.println("o3.equals of : " + o3.equals(Optional.of("000")));
        System.out.println("o3.equals ofNullable : " + o3.equals(Optional.of(arr[0])));

        // if optional is not empty then isPresent() gives true => opposite of isEmpty()
        System.out.println("o1.isPresent() : " + o1.isPresent());
        System.out.println("o2.isPresent() : " + o2.isPresent());
        System.out.println("o3.isPresent() : " + o3.isPresent());

        // -> if o1/o2/o3 are not present then for default values, the following methods
        // are used

        o1.ifPresent(System.out::println);
        o2.ifPresent(System.out::println);
        o3.ifPresent(System.out::println);

        o1.ifPresentOrElse(System.out::println, () -> System.out.println("No value !!"));
        o2.ifPresentOrElse(System.out::println, () -> System.out.println("No value !!"));
        o3.ifPresentOrElse(System.out::println, () -> System.out.println("No value !!"));

        System.out.println("o1.or : " + o1.or(() -> Optional.of("No Value")));
        System.out.println("o2.or : " + o2.or(() -> Optional.of("No Value")));
        System.out.println("o3.or : " + o3.or(() -> Optional.of("No Value")));

        System.out.println("o1.orElse : " + o1.orElse("Null value"));
        System.out.println("o2.orElse : " + o2.orElse("Null value"));
        System.out.println("o3.orElse : " + o3.orElse("Null value"));

        System.out.println("o1.orElseGet : " + o1.orElseGet(() -> "No Value"));
        System.out.println("o2.orElseGet : " + o2.orElseGet(() -> "No Value"));
        System.out.println("o3.orElseGet : " + o3.orElseGet(() -> "No Value"));

        // System.out.println("o1.orElseThrow : " + o1.orElseThrow()); // if o1 is empty
        // otherwise java.util.NoSuchElementException
        System.out.println("o2.orElseThrow : " + o2.orElseThrow()); // if o2 is empty otherwise
                                                                    // java.util.NoSuchElementException
        // System.out.println("o3.orElseThrow : " + o3.orElseThrow()); // if o3 is empty
        // otherwise java.util.NoSuchElementException

        // System.out.println("o1.orElseThrow : " + o1.orElseThrow(() -> new
        // ArithmeticException("No Value"))); // if o1 is
        // empty
        // otherwise
        // java.util.NoSuchElementException
        System.out.println("o2.orElseThrow : " + o2.orElseThrow(() -> new ArithmeticException("No Value"))); // if o2 is
                                                                                                             // empty
                                                                                                             // otherwise
                                                                                                             // java.util.NoSuchElementException
        // System.out.println("o3.orElseThrow : " + o3.orElseThrow(() -> new
        // ArithmeticException("No Value"))); // if o3 is
        // empty
        // otherwise
        // java.util.NoSuchElementException

        System.out.println("o1.hashCode() : " + o1.hashCode());
        System.out.println("o2.hashCode() : " + o2.hashCode());
        System.out.println("o3.hashCode() : " + o3.hashCode());

        // -> hashCode calculates internal value of optional instance not the optional
        // instance itself

        System.out.println("o2.hashCode() : " + o2.hashCode());
        System.out.println("000.hashCode() : " + "000".hashCode());

        System.out.println("o1.toString() : " + o1.toString());
        System.out.println("o2.toString() : " + o2.toString());
        System.out.println("o3.toString() : " + o3.toString());

        // System.out.println("o1.filter : " + o1.filter(ele -> ele != null &&
        // ele.length() != 0).get()); // otherwise java.util.NoSuchElementException
        System.out.println("o2.filter : " + o2.filter(ele -> ele != null && ele.length() != 0).get());
        // System.out.println("o3.filter : " + o3.filter(ele -> ele != null &&
        // ele.length() != 0).get()); // otherwise java.util.NoSuchElementException

        // System.out.println("o1.map : " + o1.map(ele -> ele + "...").get()); //
        // otherwise java.util.NoSuchElementException
        System.out.println("o2.map : " + o2.map(ele -> ele + "...").get()); // otherwise
                                                                            // java.util.NoSuchElementException
        // System.out.println("o3.map : " + o3.map(ele -> ele + "...").get()); //
        // otherwise java.util.NoSuchElementException

        // System.out.println("o1.flatMap : " + o1.flatMap(ele -> Optional.of(ele +
        // "...")).get()); // otherwise
        // java.util.NoSuchElementException
        System.out.println("o2.flatMap : " + o2.flatMap(ele -> Optional.of(ele + "...")).get()); // otherwise
        // java.util.NoSuchElementException
        // System.out.println("o3.flatMap : " + o3.flatMap(ele -> Optional.of(ele +
        // "...")).get()); // otherwise
        // java.util.NoSuchElementException

    }

}