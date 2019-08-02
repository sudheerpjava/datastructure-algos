package algos;

public class Majority {
    public static void main(String[] args) {

        int arr[] = {2, 2, 1, 1, 2, 1, 1,2,3,2,2};
        printMajorityElement(arr, findCandidate(arr));

    }

    public static int findCandidate(int arr[]) {
        int maj_index = 0, count = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[maj_index] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return arr[maj_index];
    }

    public static void printMajorityElement(int arr[], int candidate) {
        int count = 0;
        int length = arr.length;
        int maj_index = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == candidate) {
                maj_index = i;
                count++;
            }

        }
        if (count > length / 2) {
            System.out.println("Majority element ->  " + arr[maj_index]);
        } else {
            System.out.println("None ============");
        }
    }
}
