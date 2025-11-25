package SSAFY_Algo_0804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1206_View_이기혁 {

    private static int[] arr;
    public static void main(String[] args) throws Exception {

        /**
         * 0. 입력파일 읽어들이기
         */
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

//	        int T;
//	        T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#" + test_case + " ");

            // 여러분의 알고리즘 코드 작성하기

            int sum = 0;

            int N = Integer.parseInt(in.readLine());

            String[] scores= in.readLine().split(" ");

            arr = new int[N];

            for(int i =0; i<N;i++) {
                arr[i]= Integer.parseInt(scores[i]);

            }

            for(int i = 2; i<N-2 ; i++) {
                int leftMax = Math.max(arr[i-2],arr[i-1]);
                int rightMax = Math.max(arr[i+2], arr[i+1]);
                int totalMax = Math.max(leftMax, rightMax);

                if(arr[i] > totalMax) {
                    sum+= (arr[i] - totalMax);
                }
            }
            sb.append(sum).append("\n");


        }

        System.out.println(sb);
    }

}
