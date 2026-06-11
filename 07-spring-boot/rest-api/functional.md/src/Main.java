import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Integer>list1 = new ArrayList<>() ;
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(4);
        System.out.print(list1);
        System.out.println("");
        List<Integer>list2 = List.of(2,4,6);
        System.out.print(list2);
        System.out.println("");
        List<Integer>even = list1.stream()
                .filter(integer ->  integer %2 == 0)
                .toList();
        System.out.print(even);





    }
}