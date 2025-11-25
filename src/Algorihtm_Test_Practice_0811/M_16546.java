package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M_16546 {



    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++){

            String line = br.readLine();

            int[] arr = new int[10];

            int cnt = 0;

            for(int i =0 ; i<line.length();i++){
                int a = line.charAt(i) - '0';
                arr[a]++;
            }

            for(int i = 0; i < arr.length; i++){
                while(arr[i] >=3){
                    arr[i]-=3;
                    cnt++;
                }
            }

            for(int i =0; i<arr.length-2;i++){
                while(arr[i] >=1 && arr[i+1] >=1 && arr[i+2] >=1){
                    arr[i]-=1;
                    arr[i+1]-=1;
                    arr[i+2]-=1;
                    cnt++;
                }
            }

            if(cnt == 2){
                sb.append("#").append(test_case).append(" ").append("true");
            }else{
                sb.append("#").append(test_case).append(" ").append("false");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
