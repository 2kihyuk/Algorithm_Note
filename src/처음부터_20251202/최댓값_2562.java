package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 최댓값_2562 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[]arr = new int[9];
        int ans = Integer.MIN_VALUE;
        int max_idx = -1;

        for(int i = 0; i<9; i++){
            int N = Integer.parseInt(br.readLine());
            arr[i] = N;

            if(ans < N){
                ans = N;
                max_idx = i+1;
            }
        }

        System.out.println(ans);
        System.out.println(max_idx);




    }
}
