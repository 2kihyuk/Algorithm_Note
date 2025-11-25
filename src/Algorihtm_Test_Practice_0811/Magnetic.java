package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Magnetic {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){

            int a = Integer.parseInt(br.readLine());
            int arr[][] = new int[100][100];

            for(int i =0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =0; j<100;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for(int i =0; i< 100; i++){
                boolean isFoundOne = false;
                for(int j =0; j<100; j++){
                    if(arr[j][i] == 1){
                        isFoundOne = true;
                    }else if(arr[j][i] == 2 && isFoundOne){
                        count++;
                        isFoundOne = false;
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
