import java.util.Scanner;

public class testscanner {
   public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
         System.out.print("Age: ");
         byte age = scanner.nextByte();
         System.out.println("You are " + age);
      }
   }
}