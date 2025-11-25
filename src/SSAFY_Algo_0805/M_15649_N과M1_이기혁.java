package SSAFY_Algo_0805;

import java.util.Scanner;

public class M_15649_N과M1_이기혁 {

    static int N;
    static int M;
    static int[] number;
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isSelected = new boolean[N+1];
        number = new int[M];
        sb = new StringBuilder();

        permutation(0);
        System.out.println(sb);
    }

    private static void permutation(int cnt){
        if(cnt == M){
            for(int i = 0; i<M;i++){
                sb.append(number[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i<=N; i++){
            if(isSelected[i]){
                continue;
            }

            number[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
}
