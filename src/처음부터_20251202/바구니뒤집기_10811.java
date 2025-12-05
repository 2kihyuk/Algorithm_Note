package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바구니뒤집기_10811 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = i;
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int temp[] = new int[end-start+1];
            int  idx = 0;
            for(int j = end; j>=start; j--){
                temp[idx++] = arr[j];
            }
            idx = 0;
            for(int j = start; j<=end; j++){
                arr[j] = temp[idx++];
            }

        }

        for(int i = 1; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}

//1부터 4까지 역순
