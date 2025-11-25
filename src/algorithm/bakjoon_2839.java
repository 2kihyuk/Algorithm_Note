package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class bakjoon_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[]dp = new int[N+1];

        Arrays.fill(dp,5001);
        dp[0] = 0;

        for(int i =1; i<=N;i++){
            if(i >=3){
                if(dp[i-3] != 5001){
                    dp[i] = Math.min(dp[i],dp[i-3] + 1);
                }
            }
            if(i >= 5){
                if(dp[i-5] != 5001){
                    dp[i] = Math.min(dp[i], dp[i-5] + 1);
                }
            }
        }

        if(dp[N] == 5001){
            System.out.println(-1);
        }else{
            System.out.println(dp[N]);
        }
    }
}
