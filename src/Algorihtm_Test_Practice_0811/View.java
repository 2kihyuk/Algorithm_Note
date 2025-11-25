package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++){


            int N = Integer.parseInt(br.readLine()); //건물의 개수.

            int arr[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i =0; i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;

            for(int i = 2; i<arr.length -2 ; i++){

                int leftMax = Math.max(arr[i-2],arr[i-1]);
                int rightMax = Math.max(arr[i+2], arr[i+1]);
                int totalMax = Math.max(leftMax,rightMax);

                if(arr[i] > totalMax){
                    sum+= (arr[i] - totalMax);
                }
            }

            System.out.println("#" + test_case + " " + sum);


        }
    }
}
