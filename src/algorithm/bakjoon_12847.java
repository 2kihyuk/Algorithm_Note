package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjoon_12847 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[]arr = new long[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;

        for(int i = 0; i<M; i++){
            sum+=arr[i];
        }

        long ans = sum;

        for(int i = M; i<N; i++){
            sum += arr[i];
            sum -= arr[i-M];
            ans = Math.max(sum,ans);
        }

        System.out.println(ans);

    }
}
