package Algorihtm_Test_Practice_0811;

import java.util.Arrays;
import java.util.Scanner;

public class M_일곱난장이 {

    private static int N;
    private static int M;
    private static int[]input;
    private static int[] numbers;

    private static StringBuilder sb;

    private static boolean isFound;


    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         N = 9;
         M = 7;
         input= new int[N];
         numbers = new int[M];

         for(int i = 0 ;i<N; i++){
             input[i] = sc.nextInt();
         }
        Arrays.sort(input);
         sb= new StringBuilder();
        isFound = false;
         combi(0,0);

        System.out.println(sb);

    }

    private static void combi(int cnt, int start){

        if( cnt == M){
            int sum = 0;
            for(int H : numbers){
                sum+=H;
            }
            if(sum == 100)
            {
                for(int a : numbers){
                    sb.append(a).append("\n");
                }
                isFound = true;
            }
            return;
        }

        if(isFound){
            return;
        }

        for(int i = start; i<N; i++){
            numbers[cnt] = input[i];
            combi(cnt + 1, i+1);

            if(isFound){
                return;
            }
        }
    }

}
