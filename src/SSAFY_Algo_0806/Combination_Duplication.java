package SSAFY_Algo_0806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combination_Duplication {
    //중복 조합

    private static int N;
    private static int M;
    private static int[] input;
    private static int[] numbers;
    private static int totalCnt;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        input = new int[N];
        numbers = new int[M];
        totalCnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i< N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        combination_duplication(0,0);
        System.out.println("총 개수는 :" + totalCnt);
    }

    private static void combination_duplication(int cnt, int start){
        if(cnt == M){
            System.out.println(Arrays.toString(numbers));
            totalCnt++;
            return;
        }

        for(int i = start; i<N; i++){
            numbers[cnt] = input[i];
            combination_duplication(cnt + 1, i);
        }
    }
}
