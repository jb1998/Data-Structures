import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Litit {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("samp.txt"));
        int mod = 1000000007;
        PrintStream o = new PrintStream(new File("test.txt"));
        PrintStream console = System.out;
        System.setOut(o);
        int t = sc.nextInt();
        int iterate = 0;

        while (iterate++ < t) {
            int ans = 0;
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            boolean check = false;
            for (int i = 0; i < n; i++) {
                if (b.charAt(i) != '.') {
                    check = true;
                    ans = 0;
                    break;
                }
            }
            if (!check) {
                if (n <= 1 || a.charAt(0) != '.' || c.charAt(n-1) != '.') {
                    ans = 0;
                } else {
//                    n = n ;
                    if (n % 2 != 0) {
                        ans = 0;
                    } else {
                        ans = 1;
                        for (int i = 1; i < n - 2; ) {

                            if ((a.charAt(i) == '.' && a.charAt(i + 1) == '.') && (c.charAt(i) == '.' && c.charAt(i + 1) == '.')) {
                                ans = ((ans * 2) % mod);
                                i = i + 2;
                            } else if (a.charAt(i) != '.' && c.charAt(i) != '.') {
                                ans = 0;
                                break;
                            } else if((a.charAt(i)!='.' && c.charAt(i+1)!='.') || (a.charAt(i+1)!='.' && c.charAt(i)!='.'))
                            {
                                ans = 0;
                                break;
                            }
                                else {
                                i+=2;
                            }


                        }
                    }


                }
            }
      System.out.println("Case #"+iterate+": "+ans);
        }
        System.setOut(console);

    }
}
