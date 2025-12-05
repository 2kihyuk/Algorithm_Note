package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {
    private static int N,B;
    private static int[]arr;
    private static int minDiff;

    private static boolean[]isSelected;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            isSelected = new boolean[N];

            minDiff = Integer.MAX_VALUE;
            subset(0);
            System.out.println("#" + tc + " " + (minDiff));

        }
    }

    private static void subset(int cnt){

        if(cnt == N){
            int sum = 0;
            for(int i = 0 ; i<N; i++){
                if(isSelected[i]) sum+=arr[i];
            }
            if(sum >= B){
                minDiff = Math.min(minDiff,sum-B);
            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }
}
