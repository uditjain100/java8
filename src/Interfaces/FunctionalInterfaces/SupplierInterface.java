package Interfaces.FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        // "Integer" -> return type
        Supplier<Integer> random = () -> (int) (Math.random() * 10);
        System.out.println(random.get());
    }
}
