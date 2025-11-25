package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마이다스코테_베리메리크리스마스_조합 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

    }
    private static String answer;
    private static int nn;
    private static int ww;
    private static int[] gg;
    private static int[] input;
    private static int[] numbers;

    public String solution(int N, int W, int[] Gift) {
        answer = "NO";
        nn = N;
        ww = W;
        gg = Gift;

        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = i;
        }

        numbers = new int[3];
        combination(0, 0);
        return answer;
    }

    private static void combination(int cnt, int start) {
        if (cnt == 3) {
            int tempSum = 0;
            for (int g : numbers) {
                tempSum += gg[g];
                if(tempSum > ww) break;
            }
            if (tempSum == ww) {
                answer = "YES";
            }
            return;
        }

        for (int i = start; i < nn; i++) {
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }
}
