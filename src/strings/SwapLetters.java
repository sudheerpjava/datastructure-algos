package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwapLetters {

    public static void main(String[] args) {

        System.out.println(swap("geeks for geeks"));
        String regex;
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]");
        Matcher matcher=pattern.matcher("GeekS FOR GEEKS");
        System.out.println();
        while (matcher.find()){
            System.out.print(matcher.group());
        }

    }

    public static String swap(String letters){

        char ch[]= letters.toCharArray();
        for (int i=0;i<ch.length;i++){
            int k=i;
            while (i<ch.length && ch[i] != ' '){
                i++;
            }

            char temp= ch[k];
            ch[k] = ch[i-1];
            ch[i-1] = temp;
        }
        return  new String(ch);
    }
}
