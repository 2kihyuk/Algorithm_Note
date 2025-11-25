package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            int a = Integer.parseInt(br.readLine());

            int arr[][] = new int[100][100];

            for(int i = 0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j< 100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;

            for(int i=0; i<arr.length; i++){
                int sum = 0;
                for(int j = 0; j<arr.length;j++){
                    sum+=arr[i][j];
                }
                max = Math.max(max,sum);
            }

            for(int i = 0; i<arr.length;i++){
                int sum = 0;
                for(int j = 0; j<arr.length;j++){
                    sum+=arr[j][i];
                }
                max = Math.max(max,sum);
            }

            int aSum = 0;
            for(int i =0; i<arr.length;i++){
                aSum+=arr[i][i];
            }
            max = Math.max(max,aSum);

            int bSum = 0;
            for(int i = 0; i<arr.length; i++){
                bSum+= arr[i][arr.length-1-i];
            }
            max = Math.max(max,bSum);

            System.out.println("#" + test_case + " " + max);
        }
    }
}


