package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입국심사 {
    private static int N,M;
    private static int[]time;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            time = new int[N];

            for(int i = 0; i<N; i++){
                time[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(time);

            long left = 0;
            long right = (long) time[N-1] * M;
            long ans = right;

            while(left<=right){
                long mid = (left+right)/2;
                long sum = 0;
                for(int i = 0; i<N; i++){
                    sum+= mid/ time[i];
                    if(sum>=M) break;
                }

                if(sum >= M){
                    ans = mid;
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

            System.out.println("#" + tc + " " + ans);

        }
    }
}
