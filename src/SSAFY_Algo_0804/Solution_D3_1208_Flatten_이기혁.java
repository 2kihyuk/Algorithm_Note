package SSAFY_Algo_0804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_1208_Flatten_이기혁 {

    public static void main(String[] args) throws Exception {

        /**
         * 0. 입력파일 읽어들이기
         */
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#" + test_case + " ");

            // 여러분의 알고리즘 코드 작성하기

            int N = Integer.parseInt(in.readLine());
            String[] str = in.readLine().split(" ");
            int []arr = new int[100];


            for(int i =0; i<arr.length;i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            for(int i =0; i<N;i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[arr.length-1]--;
            }
            Arrays.sort(arr);

            int ans = arr[arr.length-1] - arr[0];

            sb.append(ans).append("\n");


        }

        System.out.println(sb);
    }
}

