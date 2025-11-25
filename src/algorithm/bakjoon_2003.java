package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjoon_2003 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[N];
        st= new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;

        while(true){
            if(sum >=M){
                if(sum == M){
                    ans++;
                }
                sum-=arr[left++];
            }else{
                if(right == len) break;
                sum +=arr[right++];
            }
        }

        System.out.println(ans);
    }
}



//int len = arr.length;
//        int left=0,right =0 ;
//        int sum = 0;
//        int cnt = 0;
//
//        while(true){
//            if(sum >= M){
//                if(sum == M) cnt++;
//                sum-=arr[left++];
//            }else{
//                if(right == len) break;
//                sum+=arr[right++];
//            }
//        }
//
//        System.out.println(cnt);
