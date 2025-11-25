package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][]arr = new int[N+1][2];
        for(int i = 1; i<=N ; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            arr[i][0] = day;
            arr[i][1] = price;
        }

    }
}
