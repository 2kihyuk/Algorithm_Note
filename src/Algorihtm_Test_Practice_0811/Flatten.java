package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){

            int dump = Integer.parseInt(br.readLine());

            int arr[] = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<100;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //dump횟수가 0보다 큰동안에 반복문을 돌리건데, 덤프 작업은 정렬시킨 배열의 가장 마지막요소를 -1, 첫번째 요소를 + 1 한다.
            //이 과정을 반복하다, 평탄화, 즉 가장 마지막 요소 - 첫번째 요소의 차가 1보다 작거나 같으면 더 이상 평탄화를 진행할 수 없고,
            //혹은 가장 마지막 요소와 첫번째 요소의 값이 같다면 이미 평탄화가 완료되어, break;
            while(dump > 0){
                Arrays.sort(arr);
                if(arr[arr.length-1] == arr[0]) break;
                if(arr[arr.length-1] - arr[0] <=1) break;

                arr[0]++;
                arr[arr.length-1]--;
                dump--;
            }

            Arrays.sort(arr); // 마지막 정렬.

            int ans = arr[arr.length-1] - arr[0];
            System.out.println("#" + test_case + " " + ans);

        }
    }
}



