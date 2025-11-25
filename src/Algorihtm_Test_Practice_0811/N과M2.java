package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N과M2 {
    private static int N;
    private static int M;
    private static int[] input;
    private static int[] numbers;
    private static StringBuilder sb;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[]  = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        input = new int[N+1];
        numbers = new int[M];

        for(int i = 0; i<=N;i++){
            input[i] = i;
        }

        sb = new StringBuilder();
        //1부터 N까지 M개를 고르는 수열.
        combi(0,1);

        System.out.println(sb);

    }

    private static void combi(int cnt, int start){
        if(cnt == M){
            for(int a : numbers){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<=N;i++){
            numbers[cnt] = input[i];
            combi(cnt+1,i+1);
        }
    }
}
