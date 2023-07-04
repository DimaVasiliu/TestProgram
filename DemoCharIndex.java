public class DemoCharIndex {
    public static void main(String[] args) {
        String nameOfTown = "ChisinauMoldova";
        char city = 'a';
        System.out.println("Index of town 'a' in ChisinauMoldova: ");
        int index = nameOfTown.indexOf(city);
        while (index >= 0) {
            System.out.println(index);
            index = nameOfTown.indexOf(city, index + 1);
        }
    }
}
