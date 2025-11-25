package SSAFY_Algo_0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
public class Solution_D3_1208_Flatten_정상훈_구현 {

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
        T = 10;  // 총 10개의 테스트 케이스 고정
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");

            // 덤프 횟수
            int maxDumpCount = Integer.parseInt(in.readLine());

            // 각 상자의 높이 값
            String[] split = in.readLine().split(" ");

//			int[] heights = Arrays.stream(split).mapToInt(s -> Integer.parseInt(s)).toArray();
            int[] heights = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                heights[i] = Integer.parseInt(split[i]);
            }

            /**
             * 2. 알고리즘 풀기
             */
            int dumpCount = 0;  // 덤프 횟수

//            while (true) {
//                Arrays.sort(heights);  // 오름차순 정렬
//
//                // 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내 인가?
//                boolean isDiffLessThanOne = heights[99] - heights[0] <= 1;
//                // 최대 덤프 횟수 이상 수행 하였는가?
//                boolean isAboveMax = dumpCount >= maxDumpCount;
//
//                if (isDiffLessThanOne || isAboveMax) {
//                    sb.append(heights[99] - heights[0]);
//                    break;
//                }
//
//                heights[99] -= 1;
//                heights[0] += 1;
//                dumpCount++;
//            }
            while(true){
                Arrays.sort(heights);

                boolean isDiffLessThanOne = heights[99] - heights[0] <=1;
                boolean isAboveMax = dumpCount >=maxDumpCount;

                if(isDiffLessThanOne || isAboveMax){
                    sb.append(heights[99] - heights[0]);
                    break;
                }
                heights[99]--;
                heights[0]++;
                dumpCount++;
            }
            sb.append("\n");
        }

        /**
         * 3. 정답 출력
         */
        System.out.println(sb);
    }

}
