import java.util.Scanner;

public class MenuDrivenProgramTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] groupSizes = {};

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 'a':
                    enterGroupSizes(scanner);
                    break;
                case 'b':
                    createSeatingPlan(groupSizes);
                    break;
                case 'c':
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a correct option.");
            }

            System.out.println();
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("a. Enter group sizes");
        System.out.println("b. Create seating plan");
        System.out.println("c. Exit");
    }

    private static void enterGroupSizes(Scanner scanner) {
        System.out.print("Enter the total number of people attending the event: ");
        scanner.nextInt();

        System.out.print("Enter the number of groups: ");
        int numGroups = scanner.nextInt();

        int[] groupSizes = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            System.out.print("Enter the size of group " + (i + 1) + ": ");
            groupSizes[i] = scanner.nextInt();
        }
        System.out.println("Group sizes entered successfully.");
    }

    private static void createSeatingPlan(int[] groupSizes) {
        // Task 2: Create the seating plan using the groupSizes array
        // ...

        System.out.println("Seating plan created successfully.");
    }
}
