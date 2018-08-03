import java.util.Scanner;

public class Codechef3 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int iterate = 0;

        while (iterate++ < t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];
            String te[] = new String[n];
//            if(iterate==1)
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                te[i] = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = te[i].charAt(j) - '0';
                }
            }
            String s = sc.next();

            for(int i=0;i<s.length();i++) {
                char finallythis = s.charAt(i);
                if (finallythis == 'L') {

                    for (int k = 0; k < n; k++) {
//                                StringBuilder sb=new StringBuilder("");
                        int count = 0;
                        for (int l = 0; l < m; l++) {
                            if (arr[k][l] == 1)
                                count++;
                        }
                        for (int l = 0; l < count; l++) {
                            arr[k][l] = 1;

                        }
                        for (int l = count; l < m; l++) {
                            arr[k][l] = 0;
                        }
                    }

                } else if (finallythis == 'R') {
                    for (int k = 0; k < n; k++) {
//                                StringBuilder sb = new StringBuilder("");
                        int count = 0;
                        for (int l = 0; l < m; l++) {
                            if (arr[k][l] == 1)
                                count++;
                        }

                        for (int l = 0; l < m - count; l++) {
//                                    sb.append("0");
                            arr[k][l] = 0;
                        }
                        for (int l = m - count; l < m; l++) {
//                                    sb.append("1");
                            arr[k][l] = 1;
                        }

//                                arr[k] = sb.toString();
                    }

                } else if (finallythis == 'U') {
                    for (int k = 0; k < m; k++) {
                        int count = 0;
                        for (int l = 0; l < n; l++) {
                            if (arr[l][k] == 1) {
                                count++;
                            }
                        }
                        for (int l = 0; l < count; l++) {
//                                    StringBuilder sb = new StringBuilder(arr[l]);
//                                    sb.setCharAt(k, '1');
//                                    arr[l] = sb.toString();
                            arr[l][k] = 1;
                        }

                        for (int l = count; l < n; l++) {
//                                    StringBuilder sb = new StringBuilder(arr[l]);
//                                    sb.setCharAt(k, '0');
//                                    arr[l] = sb.toString();
                            arr[l][k] = 0;
                        }
                    }
                } else if (finallythis == 'D') {
                    for (int k = 0; k < m; k++) {
                        int count = 0;
                        for (int l = 0; l < n; l++) {
                            if (arr[l][k] == 1) {
                                count++;
                            }
                        }
                        for (int l = 0; l < n - count; l++) {
//                                    StringBuilder sb = new StringBuilder(arr[l]);
//                                    sb.setCharAt(k, '0');
//                                    arr[l] = sb.toString();
                            arr[l][k] = 0;
                        }
                        for (int l = n - count; l < n; l++) {
//                                    StringBuilder sb = new StringBuilder(arr[l]);
//                                    sb.setCharAt(k, '1');
//                                    arr[l] = sb.toString();
                            arr[l][k] = 1;
                        }


                    }
                }
            }


            for (int i = 0; i < n; i++) {
                for(int j=0;j<m;j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }


        }
    }
}
