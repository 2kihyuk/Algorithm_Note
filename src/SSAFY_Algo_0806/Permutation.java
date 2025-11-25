package SSAFY_Algo_0806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation {
///순열
    private static int N;
    private static int M;
    private static int[] input;
    private static int[] numbers;
    private static boolean[] isSelected;
    private static int totalCnt;

    public static void main(String[] args)throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        totalCnt = 0;
        input = new int[N];
        isSelected = new boolean[N];

        numbers = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println("총 개수는 : " +totalCnt);

    }

    private static void permutation(int cnt){

        if(cnt == M){
            System.out.println(Arrays.toString(numbers));
            totalCnt++;
            return;
        }

        for(int i = 0; i<N; i++){
            if(isSelected[i]){
                continue;
            }

            numbers[cnt] = input[i];
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
}
