import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class fb2 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sa.txt"));

        PrintStream o = new PrintStream(new File("test.txt"));
        PrintStream console = System.out;
        System.setOut(o);
        int t = sc.nextInt();
        int iterate = 0;
        while (iterate++ < t) {
            String str = sc.next();

            int start = 0, end = 0;
            boolean got_point = false;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(0)) {
                    int loops = 0, loope = i;
                    while (loops < i && loope < str.length()) {
                        if (str.charAt(loops) == str.charAt(loope)) {
                            loope++;
                            loops++;
                        } else {
                            start = loops;
                            end = loope;
                            got_point = true;
                            break;
                        }
                    }
                }

                if (got_point)
                    break;
            }
            System.out.print("Case #" + (iterate) + ": ");
            if (got_point) {
                StringBuffer ans = new StringBuffer();
                for (int i = 0; i < str.length(); i++) {
                    if (i == end) {
                        ans.append(str.charAt(start));
                        break;
                    }
                    ans.append(str.charAt(i));
                }
                for (int i = start + 1; i < str.length(); i++) {
                    ans.append(str.charAt(i));
                }

                System.out.println(ans);
            } else {
                System.out.println("Impossible");
            }

        }
        System.setOut(console);

    }

}
