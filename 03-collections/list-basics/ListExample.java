
import java.util.ArrayList;
import java.util.Collections;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        System.out.println("Fruits List: " + fruits);

        Collections.sort(fruits);
        System.out.println("Sorted Fruits: " + fruits);
    }
}
