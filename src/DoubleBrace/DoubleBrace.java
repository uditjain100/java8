package DoubleBrace;

import java.util.*;

public class DoubleBrace {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list);

        List<Integer> list2 = new ArrayList<Integer>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
                this.add(4);
                this.add(5);
            }
        };
        System.out.println(list2);

    }
}