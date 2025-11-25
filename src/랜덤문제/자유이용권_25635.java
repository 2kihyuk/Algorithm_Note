package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 자유이용권_25635 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(st.nextToken());
            sum += x;
            max = Math.max(max, x);
        }

        long others = sum - max;
        long ans;

        if (max <= others + 1) {
            ans = sum;               // 전부 소진 가능
        } else {
            ans = 2 * others + 1;    // 일부만 가능
        }

        System.out.println(ans);
    }
}