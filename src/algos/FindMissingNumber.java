package algos;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8};
        System.out.println(getMissingNummber(arr, 7));
        int[] ar = {1, 2, 2, 3, 3, 4, 4, 1, 5, 6, 6};

        System.out.println("Odd occurence  ->  " + getOddOccurence(ar));
        int[] replaceArr = {6, 12, 6, 10, 5, 2};
        for (int i : replaceGreatestElement(replaceArr)) {
            System.out.print(i + "  ");
        }
        System.out.println();
        int[] fixedPoint= {-2,-1,0,2,3,4,6};
        System.out.println(findFixedPoint(fixedPoint));

    }

    public static int getMissingNummber(int[] a, int n) {
        int i = 0;
        int x1 = a[0];
        int x2 = 1;

        for (i = 1; i < n; i++)
            x1 = x1 ^ a[i];
        for (i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;
        return x1 ^ x2;

    }

    public static int getOddOccurence(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static int[] replaceGreatestElement(int[] ar) {
        int max_elemnt = ar[ar.length - 1];
        ar[ar.length - 1] = -1;
        for (int i = ar.length - 2; i >= 0; i--) {
            if (max_elemnt < ar[i]) {
                max_elemnt = ar[i];
            }
            ar[i] = max_elemnt;
        }
        return ar;
    }

    public static int findFixedPoint(int arr[]) {
        return binarySearch(arr, 0, arr.length);
    }

    private static int binarySearch(int[] arr, int low, int high) {
        if (high > low) {
            int mid = (low + high) / 2;
            if (arr[mid] == mid)
                return mid;
            if (mid > arr[mid]) {
                return binarySearch(arr, mid + 1, high);
            } else {
                return binarySearch(arr, low, mid);
            }
        }
        return -1;
    }
}

