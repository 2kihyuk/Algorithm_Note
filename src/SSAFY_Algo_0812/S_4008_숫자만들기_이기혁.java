
package SSAFY_Algo_0812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_4008_숫자만들기_이기혁 {
    private static int N;
    private static int[] arr;
    private static int[] opers;

    private static int maxResult;
    private static int minResult;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine().trim());

            opers = new int[4]; // +, -, *, /
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 4; i++) {
                opers[i] = Integer.parseInt(st.nextToken());
            }

            arr = new int[N];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 테스트케이스마다 결과값 초기화 필수
            maxResult = Integer.MIN_VALUE;
            minResult = Integer.MAX_VALUE;

            // DFS 시작: 첫 번째 숫자(arr[0])를 초기값으로, 다음 숫자(arr[1])부터 연산 시작
            dfs(1, arr[0]);

            System.out.println("#" + test_case + " " + (maxResult - minResult));
        }
    }

    // index: 현재 탐색할 숫자의 인덱스 (arr[1]부터 시작)
    // current_value: 이전까지의 연산 결과
    private static void dfs(int index, int current_value) {
        // 모든 숫자에 대한 연산을 완료하면 종료
        if (index == N) {
            maxResult = Math.max(current_value, maxResult);
            minResult = Math.min(current_value, minResult);
            return;
        }

        // 더하기 연산
        if (opers[0] > 0) {
            opers[0]--;
            dfs(index + 1, current_value + arr[index]);
            opers[0]++; // 백트래킹: 사용한 연산자 개수 복구
        }

        // 빼기 연산
        if (opers[1] > 0) {
            opers[1]--;
            dfs(index + 1, current_value - arr[index]);
            opers[1]++;
        }

        // 곱하기 연산
        if (opers[2] > 0) {
            opers[2]--;
            dfs(index + 1, current_value * arr[index]);
            opers[2]++;
        }

        // 나누기 연산
        if (opers[3] > 0) {
            opers[3]--;
            dfs(index + 1, current_value / arr[index]);
            opers[3]++;
        }
    }
}
