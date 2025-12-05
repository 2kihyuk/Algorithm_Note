package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공넣기_10810 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[N+1];


        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int startidx = Integer.parseInt(st.nextToken());
            int endidx = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for(int j = startidx; j<=endidx; j++){
                arr[j] = ball;
            }
        }

        for(int i = 1; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }
}
