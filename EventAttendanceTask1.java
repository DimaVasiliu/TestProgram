import java.util.Scanner;

public class EventAttendanceTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of people attending the event: ");
        int totalAttendees = scanner.nextInt();

        System.out.print("Enter the number of groups: ");
        int numGroups = scanner.nextInt();

        int[] groupSizes = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            System.out.print("Enter the size of group " + (i + 1) + ": ");
            groupSizes[i] = scanner.nextInt();
        }

        scanner.close();

        // Error checking
        int sumOfGroupSizes = 0;
        for (int size : groupSizes) {
            sumOfGroupSizes += size;
        }

        if (sumOfGroupSizes != totalAttendees) {
            System.out.println("Error: The sum of group sizes does not match the total number of attendees.");
            // Handle the error as needed
        } else {
            // Perform further calculations or tasks based on the input data
            // ...
        }
    }
}
