import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ArrayList arrayList= new ArrayList<String>();
        arrayList.add("test");
        System.out.println(arrayList.contains("test"));
       // System.out.println("test");
        String s = "bab";
        Set set= new HashSet<String>();
        for(String s1:s.split("")){
            set.add(s1);
        }
        System.out.println(set.size());
        System.out.println("abc".contains("cba"));
        String str="bca";
        Arrays.sort(str.split(""));
        int j =4;
        int smallestLength=0;
        for (int i=0;i<s.length() && j<s.length()+1;i++){
            String[] sub = s.substring(i,j).split("");
            boolean flag= false;
            for (int k=0;k<sub.length;k++){
                if(sub[k] == sub[k++] ){
                    flag = true;
                }else{
                    flag = false;
                }
                if(flag && smallestLength==0){
                    smallestLength=sub.length;
                }
            }
            j++;
        }
    }
}
