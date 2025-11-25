package SSAFY_Algo_0804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1204_최빈수구하기_이기혁 {

    private static int[] counter;//빈도 수를 저장할 배열( 인덱스 번호는 점수)
    public static void main(String[] args) throws Exception {

        /**
         * 0. 입력파일 읽어들이기
         */
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");


            // 여러분의 알고리즘 코드 작성하기

            /**
             * 1.입력 파일 객체화
             *
             *  **/
            counter = new int[101];
            in.readLine(); // 테케 번호 부분 건너뛰기

            String[] scores= in.readLine().split(" ");

            /**
             * 2.알고리즘 풀기
             *
             *  **/
            for(int i =0; i< scores.length;i++) {
                int score = Integer.parseInt(scores[i]);
                counter[score]++;
            }

            /**
             * 3.정답 출력
             *
             *  **/
            int max = Integer.MIN_VALUE;
            int answer = -1;
            for(int score = 0; score<=100 ;score++) {
                if(max <=counter[score]) {
                    max = counter[score];
                    answer = score;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}