package algorithm;

import java.util.Scanner;
import java.io.FileInputStream;

class swea1961
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int arr[][] = new int[n][n];

            for(int i =0; i<n;i++){
                for(int j =0; j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            String rot90[][] = new String[n][n];
            String rot180[][] = new String[n][n];
            String rot270[][] = new String[n][n];

            for(int i =0; i<n;i++){
                for(int j =0; j<n; j++){
                    rot90[i][j] = Integer.toString(arr[n-j-1][i]);
                    rot180[i][j] = Integer.toString(arr[n-i-1][n-j-1]);
                    rot270[i][j] = Integer.toString(arr[j][n-i-1]);
                }
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                // 90도
                for (int j = 0; j < n; j++) {
                    sb.append(rot90[i][j]);
                }
                sb.append(" ");
                // 180도
                for (int j = 0; j < n; j++) {
                    sb.append(rot180[i][j]);
                }
                sb.append(" ");
                // 270도
                for (int j = 0; j < n; j++) {
                    sb.append(rot270[i][j]);
                }
                System.out.println(sb.toString());
            }




        }
    }
}