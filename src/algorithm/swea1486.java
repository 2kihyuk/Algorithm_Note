package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

class swea1486
{

    static int N, B;             // 점원 수, 선반 높이
    static int[] height;         // 점원들의 키
    static int min;              // B 이상 중 최소 탑 높이

    // DFS + 백트래킹
    static void dfs(int index, int sum) {
        // 1. 현재 합이 B 이상이면 최소값 갱신하고 종료 (가지치기)
        if (sum >= B) {
            min = Math.min(min, sum);
            return;
        }

        // 2. 인덱스가 N이면 종료 (모든 점원 탐색 완료)
        if (index == N) return;

        if (sum >= min) return;

        // 3. 현재 점원을 포함하는 경우
        dfs(index + 1, sum + height[index]);

        // 4. 현재 점원을 포함하지 않는 경우
        dfs(index + 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();    // 점원 수
            B = sc.nextInt();    // 선반 높이
            height = new int[N];
            min = Integer.MAX_VALUE;

            // 점원 키 입력
            for (int i = 0; i < N; i++) {
                height[i] = sc.nextInt();
            }

            // DFS 시작
            dfs(0, 0);

            // 결과 출력
            System.out.println("#" + test_case + " " + (min - B));
        }
    }
}

//int []arr = new int[N];
//            ArrayList<Integer> list = new ArrayList<>();
//            for(int i =0; i<N;i++){
//                list.add(sc.nextInt());
////                arr[i] = sc.nextInt();
//            }
//            int[]dp = new int[N];
//            Collections.sort(list,Collections.reverseOrder());
//            dp[0] = list.get(0);
//            dp[1] = dp[0] + list.get(1);
//            int sum = 0;
//
//            for(int i =2; i<N;i++){
//                dp[i] = dp[i-2] + dp[i-1];
//                if(dp[i] >B){
//                    sum = dp[i] - B;
//                    break;
//                }
//            }