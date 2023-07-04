public class HelloWorld {
    public static void main(String[] args) {
        String message = "   Hello World" + "!  !!";
        String message1 = "c:\\Windows\\...";
        System.out.println(message.endsWith("!!"));
        System.out.println(message.startsWith("!!"));
        System.out.println(message.indexOf("H", 0));
        System.out.println(message.indexOf("sky", 0));
        System.out.println(message.length());
        System.out.println(message.replace("!", "*"));
        System.out.println(message.toLowerCase());
        System.out.println(message.trim());
        System.out.println(message1 );
    }
}