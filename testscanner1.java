import java.util.Scanner;

public class testscanner1 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Name: ");
      String name = scanner.nextLine().trim();
      System.out.println("You are " + name);
    }
  }
}
