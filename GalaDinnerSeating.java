import java.util.Scanner;

public class GalaDinnerSeating {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Enter the number of groups attending an event");
            System.out.println("2. Create seating plan");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    enterGroupSizes(scanner);
                    break;
                case 2:
                    createSeatingPlan();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        } while (option != 3);

        scanner.close();
    }

    private static void enterGroupSizes(Scanner scanner) {
        System.out.print("Enter the number of groups: ");
        int numGroups = scanner.nextInt();

        int[] groupSizes = new int[6];

        for (int i = 0; i < numGroups; i++) {
            System.out.print("Enter the group size for group " + (i + 1) + ": ");
            int groupSize = scanner.nextInt();

            if (groupSize >= 2 && groupSize <= 6) {
                groupSizes[groupSize - 2]++;
            } else {
                System.out.println("Invalid group size. Group size should be between 2 and 6.");
                i--;
            }
        }

        System.out.println("Group sizes entered successfully.");
    }

    private static void createSeatingPlan() {
        int[] tableSizes = {6, 8};
        int[] groupSizes = {0, 0, 0, 0, 0}; // Group sizes from 2 to 6
        int totalPeople = 0;
        int totalTables = 0;

        // Sample data from Table 1
        int[][] eventData = {
                {4, 1, 0, 3, 5},
                {3, 4, 2, 0, 3},
                {5, 1, 5, 2, 1},
                {1, 2, 4, 1, 2},
                {0, 3, 2, 4, 2},
                {1, 3, 3, 3, 0},
                {3, 3, 3, 0, 4},
                {2, 1, 4, 1, 2}
        };

        for (int i = 0; i < eventData.length; i++) {
            int[] eventGroupSizes = eventData[i];
            int numGroups = 0;
            int numPeople = 0;

            for (int j = 0; j < eventGroupSizes.length; j++) {
                groupSizes[j] = eventGroupSizes[j];
                numGroups += eventGroupSizes[j];
                numPeople += (j + 2) * eventGroupSizes[j];
            }

            int[] tableCounts = calculateTableCounts(groupSizes, tableSizes);

            System.out.println("Event #" + (i + 1));
            System.out.println("Group size 2: " + groupSizes[0]);
            System.out.println("Group size 3: " + groupSizes[1]);
            System.out.println("Group size 4: " + groupSizes[2]);
            System.out.println("Group size 5: " + groupSizes[3]);
            System.out.println("Group size 6: " + groupSizes[4]);
            System.out.println("Number of groups: " + numGroups);
            System.out.println("Total people at event: " + numPeople);
            System.out.println("Total tables required: " + (tableCounts[0] + tableCounts[1]));
            System.out.println("Tables of size 6 required: " + tableCounts[0]);
            System.out.println("Tables of size 8 required: " + tableCounts[1]);
            System.out.println();

            totalPeople += numPeople;
            totalTables += (tableCounts[0] + tableCounts[1]);
        }

        System.out.println("Overall Summary");
        System.out.println("Total people for all events: " + totalPeople);
        System.out.println("Total tables required for all events: " + totalTables);
    }

    private static int[] calculateTableCounts(int[] groupSizes, int[] tableSizes) {
        int[] tableCounts = new int[tableSizes.length];

        for (int i = groupSizes.length - 1; i >= 0; i--) {
            int groupSize = i + 2;
            int tableSizeIndex = getTableSizeIndex(groupSize, tableSizes);

            while (groupSizes[i] > 0) {
                groupSizes[i]--;
                tableCounts[tableSizeIndex]++;

                int remainingSeats = tableSizes[tableSizeIndex] - groupSize;

                if (remainingSeats > 0) {
                    int remainingGroupSize = findGroupSize(groupSizes, remainingSeats);
                    if (remainingGroupSize != -1) {
                        groupSizes[remainingGroupSize - 2]--;
                    } else {
                        // If no group of remaining size is found, try the next smaller table size
                        tableSizeIndex = (tableSizeIndex + 1) % tableSizes.length;
                    }
                } else {
                    // If remaining seats are zero, try the next smaller table size
                    tableSizeIndex = (tableSizeIndex + 1) % tableSizes.length;
                }
            }
        }

        return tableCounts;
    }

    private static int getTableSizeIndex(int groupSize, int[] tableSizes) {
        for (int i = 0; i < tableSizes.length; i++) {
            if (tableSizes[i] >= groupSize) {
                return i;
            }
        }
        return -1;
    }

    private static int findGroupSize(int[] groupSizes, int seats) {
        for (int i = groupSizes.length - 1; i >= 0; i--) {
            if (groupSizes[i] > 0 && (i + 2) <= seats) {
                return i + 2;
            }
        }
        return -1;
    }
}