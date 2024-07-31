package finalDir;

public class Final {
        public static void main(String[] args) {
                int[] arr = { 1, 2, 3, 4, 5 };
                for (final int ele : arr)
                        System.out.println(ele);
        }
}
