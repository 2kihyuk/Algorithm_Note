package SSAFY_Algo_0804;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1206_View_정상훈_구현 {

    // 새로운 테스트 케이스마다 덮어쓰기 하므로 한 번만 배열을 생성해도 됨
    private static int[] num = new int[1000];  // 가로길이는 1000이하로 주어진다.

    // 좌, 우 거리가 각각 2 이하인 건물 중 가장 높은 건물의 높이
    private static int getMax(int idx) {
        int max = num[idx - 2];

        if (max < num[idx - 1]) {
            max = num[idx - 1];
        }

        if (max < num[idx + 1]) {
            max = num[idx + 1];
        }

        if (max < num[idx + 2]) {
            max = num[idx + 2];
        }

        return max;
    }

    // 결과를 한 번에 출력하기 위한 StringBuilder
    private static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {

        /**
         * 0. 입력파일 읽어들이기
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 1. 입력 파일 객체화
         */
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");

            int sum = 0;  // 누적 합 (총 조망권 확보 세대수)
            int max = Integer.MIN_VALUE;

            int N = Integer.parseInt(in.readLine());

            String[] H = in.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(H[i]);
            }

            /**
             * 2. 알고리즘 풀기
             */
            for (int i = 2; i < N - 2; i++) {
                max = getMax(i);
                if (max < num[i]) {
                    sum += num[i] - max;
                }
            }

            /**
             * 3. 정답 출력
             */
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
