import java.util.Arrays;

public class fivenamesearch {
    public static void main(String[] args) {
        String[] strArray = new String[] { "Michael Smith", "Ann Taylor", "Ben Smith", "Jack First", "Jared Lowe" };
        // Array to store first name
        String[] fNameArray = new String[strArray.length];

        for (int k = 0; k < strArray.length; k++) {
            // copy all last names to compare
            int idx = strArray[k].indexOf(' ');
            fNameArray[k] = strArray[k].substring(0, idx);
        }
        System.out.println(Arrays.toString(fNameArray));
        // compare the last name
        for (int i = 0; i < fNameArray.length; i++) {
            // compare strings using equals method
            if (fNameArray[i].equals("Michael")) {
                System.out.println("One of the first name is Jack");
            }
        }
    }
}