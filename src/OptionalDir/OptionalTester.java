package OptionalDir;

import java.util.*;

public class OptionalTester {

    public static void main(String[] args) {
        String[] arr = new String[3];
        arr[0] = "000";

        Optional<String> optional = Optional.empty();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        // System.out.println(optional.get()); // java.util.NoSuchElementException

        // optional = Optional.of(arr[2]); // java.lang.NullPointerException

        optional = Optional.ofNullable(arr[2]);
        System.out.println(optional);
        // System.out.println(optional.get()); // java.util.NoSuchElementException

        optional = Optional.of(arr[0]);
        System.out.println(optional);
        System.out.println(optional.get());

        System.out.println(optional.equals(Optional.of(arr[0])));
        System.out.println(optional.equals(Optional.of("000")));

        System.out.println(optional.isPresent());
        optional.ifPresent((ele) -> {
            System.out.println(ele);
        });

        optional = Optional.ofNullable(arr[2]);
        optional.ifPresentOrElse((ele) -> {
            System.out.println("Value : " + ele);
        }, () -> {
            System.out.println("No Value is their");
        });

        System.out.println(Optional.ofNullable(arr[2]).or(() -> Optional.ofNullable("Null is Their")));

        // System.out.println(Optional.of(arr[2]).orElse("Null value")); //
        // java.lang.NullPointerException
        System.out.println(Optional.ofNullable(arr[2]).orElse("Null value"));
        // System.out.println(Optional.of(arr[2]).orElseGet(() -> "Null value again"));
        // java.lang.NullPointerException
        System.out.println(Optional.ofNullable(arr[2]).orElseGet(() -> "Null value again"));

        // System.out.println(Optional.ofNullable(arr[2]).orElseThrow());
        // java.util.NoSuchElementException: No value present
        // System.out.println(
        // Optional.ofNullable(arr[2]).orElseThrow(() -> new ArithmeticException("Null
        // value exception")));
        // java.lang.ArithmeticException: Null value exception

        optional = Optional.of(arr[0]);
        System.out.println(optional.hashCode());
        System.out.println(arr[0].hashCode());

        Optional<List<Integer>> optional2 = Optional.ofNullable(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(optional2.toString());

        System.out.println(optional.filter(ele -> ele != null && ele.length() != 0).get());

        System.out.println(optional2.map(ele -> "" + ele + " ... "));
    }

}