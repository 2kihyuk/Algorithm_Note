package algorithm;

import java.util.Scanner;
import java.io.FileInputStream;

class swea2058
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int N = sc.nextInt();
            int ans = 0;

            String a = String.valueOf(N);
            for(char x : a.toCharArray()){
                ans+= (x -'0');
            }
            System.out.println("#" + test_case + " " + ans );
        }
    }
}