public class leetcode_the_k_in_list {
    public static void main(String[] args) {
        int a[] = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        int c = a[0];
        int length = 9;
        for (int i = 1; i < length; i++) {
            c = c ^ a[i];
        }
        System.out.println(c);

    }
}
