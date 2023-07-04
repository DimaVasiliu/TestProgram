import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeatingPlanTask2 {
    public static void main(String[] args) {
        int[] groupSizes = { 10, 8, 6, 5, 5, 4, 3, 2 }; // Example group sizes

        int[] sortedGroupSizes = Arrays.copyOf(groupSizes, groupSizes.length);
        Arrays.sort(sortedGroupSizes);
        reverseArray(sortedGroupSizes);

        List<Integer> tables = new ArrayList<>();
        int totalTables = 0;

        while (sortedGroupSizes.length > 0) {
            if (tables.isEmpty()) {
                tables.add(sortedGroupSizes[0]);
                sortedGroupSizes = removeElement(sortedGroupSizes, 0);
            } else {
                boolean groupSeated = false;
                for (int i = 0; i < tables.size(); i++) {
                    if (tables.get(i) >= sortedGroupSizes[0]) {
                        tables.set(i, tables.get(i) - sortedGroupSizes[0]);
                        sortedGroupSizes = removeElement(sortedGroupSizes, 0);
                        groupSeated = true;
                        break;
                    }
                }
                if (!groupSeated) {
                    tables.add(sortedGroupSizes[0]);
                    sortedGroupSizes = removeElement(sortedGroupSizes, 0);
                }
            }
        }

        totalTables = tables.size();

        System.out.println("Total number of tables required: " + totalTables);
        for (int i = 0; i < totalTables; i++) {
            int tableSize = tables.get(i);
            int groupsSeated = groupSizes.length - sortedGroupSizes.length;
            int vacantSeats = tableSize * groupsSeated - sumArray(groupSizes);
            System.out.println("Table " + (i + 1) + ": Size=" + tableSize + "  Groups Seated=" + groupsSeated
                    + "  Vacant Seats=" + vacantSeats);
        }
    }

    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static int[] removeElement(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
    }

    private static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
