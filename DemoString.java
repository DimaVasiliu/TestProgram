public class DemoString {
    public static void main(String[] args) {
        String s = "HowDoYouDo?";
        String result = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i != 0 && Character.isUpperCase(c)) {
                result += ' ';
                c = Character.toLowerCase(c);
            }
            result += c;
        }
        System.out.println(result);
    }
}