import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resolution {

    public static void main(String[] args) {

        String list = """
                3 4
                4 3
                2 5
                1 3
                3 9
                10 3
                """;

        List<Integer> leftList = getSublist(0, list);
        List<Integer> rightList = getSublist(1, list);

        int total = getTotal(leftList, rightList);

        System.out.println("Total distance = " + total);
    }

    public static List<Integer> getSublist(int index, String list) {
        String listFormatted = list.replace("\n", " ").trim();

        String[] numbers = listFormatted.split("\\s+");

        List<Integer> sublist = new ArrayList<>();
        for (int i = index, size = numbers.length; i < size; i += 2) {
            sublist.add(
                    Integer.parseInt(numbers[i])
            );
        }

        return sublist.stream()
                .sorted()
                .toList();
    }

    private static int getTotal(List<Integer> leftList, List<Integer> rightList) {
        // It is assumed that both lists have the same size
        int size = rightList.size();
        int totalDistance = 0;

        for (int i = 0; i < size; i++) {
            int distance = leftList.get(i) - rightList.get(i);
            if (distance > 0)
                totalDistance += distance;
            else
                totalDistance -= distance;
        }

        return totalDistance;
    }
}
