package regular_expressions;

public class Regex4 {
    public static void main(String[] args) {
        String s1 = "Privet,   moi drug! Kak   idet  izuchenie      Java?";

        System.out.println(s1);

//        s1 = s1.replace("Java", "Sql");

//        s1 = s1.replaceAll(" {2,}", " ");

//        s1 = s1.replaceAll("\\bi\\w+", "444");
        s1 = s1.replaceFirst("\\bi\\w+", "444");
        System.out.println(s1);
    }
}
