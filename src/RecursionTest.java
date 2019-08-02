public class RecursionTest {
    private static int fab1 = 0, fab2 = 1, fab3 = 0;

    public static void main(String[] args) {
        RecursionTest recursionTest = new RecursionTest();
        recursionTest.print(5);
        System.out.print(fab1 + " " + fab2);
        recursionTest.fabonacci(10);
    }

    private void print(int n) {
        System.out.println(multiply(n));
    }

    private int multiply(int n) {
        if (n <= 0) {
            return 1;
        }
        return n * multiply(n - 1);
    }

    private void fabonacci(int n) {
        if (n > 0) {
            fab3 = fab1 + fab2;
            fab1 = fab2;
            fab2 = fab3;
            System.out.print(" " + fab3);
            fabonacci(n - 1);
        }

    }
}
