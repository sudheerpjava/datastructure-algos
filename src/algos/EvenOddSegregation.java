package algos;

public class EvenOddSegregation {
    public static void main(String[] args) {

        int arr[] = {0, 1, 0, 0, 1, 1, 1, 0, 0, 0};
        segregate(arr);
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }

    private static void segregate(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[left] == 0 && left < right) {
                left++;
            }
            while (arr[right] == 1 && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }

    }
}
