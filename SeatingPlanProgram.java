import java.util.Scanner;

public class SeatingPlanProgram {
    private static int totalPeople;
    private static int remainingSeats;
    private static int tables6;
    private static int tables8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    enterGroupData(scanner);
                    break;
                case 2:
                    createSeatingPlan();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Seating Plan Program Menu");
        System.out.println("1. Enter the number of groups attending the event");
        System.out.println("2. Create seating plan");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void enterGroupData(Scanner scanner) {
        System.out.print("Enter the number of groups: ");
        int numGroups = scanner.nextInt();
        int totalPeopleCount = 0;

        for (int i = 1; i <= numGroups; i++) {
            System.out.println("Group " + i);
            System.out.print("Enter the number of people: ");
            int groupSize = scanner.nextInt();
            totalPeopleCount += groupSize;
        }

        totalPeople = totalPeopleCount;
        remainingSeats = totalPeopleCount;
        tables6 = 0;
        tables8 = 0;

        System.out.println("Group data entered successfully!");
    }

    private static void createSeatingPlan() {
        if (totalPeople == 0) {
            System.out.println("Please enter group data first.");
            return;
        }

        while (remainingSeats > 0) {
            if (remainingSeats >= 8 && tables8 < tables6) {
                tables8++;
                remainingSeats -= 8;
            } else if (remainingSeats >= 6) {
                tables6++;
                remainingSeats -= 6;
            } else {
                break;
            }
        }

        int vacantSeats = (tables8 * 8 + tables6 * 6) - totalPeople;

        System.out.println("Seating plan created successfully!");
        System.out.println("Total number of tables (8 seats): " + tables8);
        System.out.println("Total number of tables (6 seats): " + tables6);
        System.out.println("Vacant seats: " + vacantSeats);
    }

}