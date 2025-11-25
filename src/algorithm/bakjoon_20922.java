package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjoon_20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr= new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int[]countArr = new int[100001];
        int ans = 0;

        while(right<N){
            int num = arr[right];

            if(countArr[num] <M){
                countArr[num]++;
                right++;
                ans = Math.max(ans, right-left);
            }else{
                countArr[arr[left]]--;
                left++;
            }
        }

        System.out.println(ans);
    }
}
