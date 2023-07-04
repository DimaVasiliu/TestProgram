import java.util.Scanner;

public class DemoString1 {
    public static void main(String[] args) {
        try (// System.in is a standart input stream
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first name: ");
            // read string
            String str1 = scanner.nextLine();
            System.out.print("Enter last name: ");
            // read string
            String str2 = scanner.nextLine();
            // Concatenating one string
            String strFullName = str1.concat(" ").concat(str2);
            System.out.println(strFullName);
        }
    }
}
