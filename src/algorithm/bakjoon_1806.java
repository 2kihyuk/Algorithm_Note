package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjoon_1806 {
    public static void main(String[] args)throws Exception {
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
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int len = arr.length;

        while(true){
            if(sum >= M){
                int tempLen = right- left;
                minLen = Math.min(tempLen,minLen);
                sum-=arr[left++];
            }else{
                if(right == len) break;
                sum += arr[right++];
            }
        }

        if(minLen == Integer.MAX_VALUE){
            minLen = 0;
        }
        System.out.println(minLen);
    }
}
