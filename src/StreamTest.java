import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add(-3);
        list.add(-5);
        list.add(100);
        list.add(50);
        //list.add(20.00);
     /*   list.add("test");
        list.add("Test234");*/

        List collect = (List) list.stream().filter(o -> !(0 >= (Integer) o)).limit(2).collect(Collectors.toList());

        System.out.println(collect);


        Object[] array;
        List<String> words = Arrays.asList("I this i am done what i have to be So please mind your shelf".split(" "));

        Map collect1 = words.stream().
                collect(groupingBy(Function.identity(), counting()));
        /*List lits1 = collect1.entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());*/
        Object collect2 = collect1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(collect2);


    }
}
