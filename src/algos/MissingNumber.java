package algos;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 3, 5, 3};
        int[] brr = {7, 2, 5, 4, 6, 3, 5, 3};
        int[] teemp ;
        for (int b:brr){
            try {
                System.out.println(arr[b]);
            }catch (Exception e){
                System.out.println(b);
            }
        }

    //    System.out.println(7^2^5^5);
    }

}