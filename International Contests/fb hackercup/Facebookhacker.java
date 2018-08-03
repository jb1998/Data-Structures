import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Facebookhacker {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("tourist.txt"));

        PrintStream o = new PrintStream(new File("test.txt"));
        PrintStream console=System.out;
        System.setOut(o);
        int t = sc.nextInt();
        int iterate = 0;
        while (iterate++ < t) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long v = sc.nextLong();
            String arr[] = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            int gnos = 0;
            int pt1 = 0;
            while (true) {
                if ((pt1 + k - 1) < n) {
                    gnos++;

                    pt1 = pt1 + k - 1;
                    pt1++;
                    if (pt1 == n)
                        break;
                } else {
                    pt1 = pt1 + k - 1;
                    pt1 = pt1 - (n);
                    gnos++;
                    pt1++;

                }
            }
            int left_out = 0;
            if (v - 5 > gnos) {
                left_out = (int) ((v - 5) % gnos);
            } else {
                left_out = (int) v - 5;
            }
            left_out+=5;
            int startp = 0;
            for (int i = 0; i < left_out - 1; i++) {
                if (startp + k - 1 < n) {
                    startp = startp + k - 1;
                    startp++;
                } else {
                    startp = startp + k - 1;
                    startp = startp - n;
                    startp++;
                }
            }
            int arrans[] = new int[n];
            System.out.print("Case #" + (iterate) + ": ");
            if (startp + k - 1 < n) {
                for (int i = startp; i < startp + k; i++) {
                    arrans[i] = 1;
                }
            } else {
                int ktimes = 0;
                for (int i = startp; i < n; i++) {
                    arrans[i] = 1;
                    ktimes++;
                }

                for (int i = 0; ktimes < k; i++) {
                    arrans[i] = 1;
                    ktimes++;
                }
            }
            for (int p = 0; p < n; p++) {
                if (arrans[p] == 1) {
                    System.out.print(arr[p]+" ");
                }
            }
            System.out.println();


        }
        System.setOut(console);

    }
}
