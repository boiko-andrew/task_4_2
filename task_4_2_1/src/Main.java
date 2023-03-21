import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static List<Integer> intList =
            Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
    public static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        // Filter positive and even integers from initial list
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) > 0 && intList.get(i) % 2 == 0) {
                resultList.add(intList.get(i));
            }
        }

        // Sort midline list
        resultList.sort(Comparator.naturalOrder());

        // Print sorted list
        System.out.println(Arrays.toString(resultList.toArray()));
    }
}