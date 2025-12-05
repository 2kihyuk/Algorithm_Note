package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 별찍기_2444 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        // 위쪽 (1 ~ N)
        for (int i = 1; i <= N; i++) {
            // 공백
            for (int j = 0; j < N - i; j++) {
                sb.append(' ');
            }
            // 별
            for (int j = 0; j < 2 * i - 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        // 아래쪽 (N-1 ~ 1)
        for (int i = N - 1; i >= 1; i--) {
            // 공백
            for (int j = 0; j < N - i; j++) {
                sb.append(' ');
            }
            // 별
            for (int j = 0; j < 2 * i - 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
