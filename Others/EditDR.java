import java.util.Scanner;

public class EditDR {
    public static int editDistance(String s1, String s2) {
        if (s1.length() == 0)
            return s2.length();
        if (s2.length() == 0)
            return s1.length();
        if (s1.charAt(0) == s2.charAt(0))
            return editDistance(s1.substring(1), s2.substring(1));
        int d1 = 1 + editDistance(s1.substring(1), s2);
        int d2 = 1 + editDistance(s2, s1.substring(1));
        int d3 = 1 + editDistance(s1.substring(1), s2.substring(1));
        return Math.min(Math.min(d1, d2), d3);
    }

    public static void main(String args[]) {
//        Scanner sc =  new Scanner(System.in);
//
        System.out.println(editDistance("abc", "dc"));
    }
}
