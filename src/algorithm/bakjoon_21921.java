package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjoon_21921 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i<M; i++){
            sum+=arr[i];
        }

        int max = sum;
        int cnt = 1;

        for(int i = M; i<N; i++){
            sum += arr[i];
            sum -= arr[i-M];
            if(max < sum){
                max = sum;
                cnt = 1;
            }else if(max == sum){
                max = sum;
                cnt++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }

    }
}
