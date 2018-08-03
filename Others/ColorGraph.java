import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ColorGraph {
    static boolean[] isvisited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[][] = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        isvisited = new boolean[n+1];
        for (int i = 1; i < n; i++) {
            if (!isvisited[i]) {
                boolean ans = getresult(arr, i);
                if (!ans) {
                   System.out.println("NO");
                   return;
                }
            }
        }
        System.out.println("YES");

    }

    private static boolean getresult(int[][] arr, int start) {
        int ans[] = new int[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        ans[start] = -1;
        isvisited[start] = true;
        while (!queue.isEmpty()) {
            int putin = 0;
            int top = queue.peek();
            queue.remove(top);
            if (ans[top] == -1) {
                putin = -2;
            } else {
                putin = -1;
            }
            for (int i = 0; i < arr.length; i++) {
                if (isvisited[i] == false && arr[top][i] == 1) {
                    queue.add(i);
                    ans[i] = putin;
                    isvisited[i]=true;
                } else if (arr[top][i] == 1) {
                    if (ans[i] != putin)
                        return false;
                }
            }
        }
        return true;
    }
}
