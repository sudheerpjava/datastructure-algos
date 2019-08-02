package algos;

public class LeaderInArray {
    public static void main(String[] args) {
        int arr[] = {16,17,0,8,3,1,5,2};
        printLeaders(arr);
    }

    private static void printLeaders(int[] arr) {

        int n= arr.length;
        int maxElementFromRight = arr[n-1];
        System.out.print(maxElementFromRight);

        for (int i=n-2;i>=0;i--){
            if(maxElementFromRight<arr[i]) {
                maxElementFromRight = arr[i];
                System.out.print(" "+maxElementFromRight);
            }
        }
    }
}
