package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baby_gin {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int[] arr = new int[10];

        for(int i = 0; i<line.length();i++){
            int a = line.charAt(i) - '0';
            arr[a]++;
        }
        boolean ans = false;
        int babyginCnt = 0;

        for(int i = 0; i<arr.length;i++){
            while(arr[i] >= 3){
                babyginCnt++;
                arr[i]-=3;
            }
        }

        for(int i=0;i<arr.length-2;i++){
            while(arr[i] >=1 && arr[i+1] >=1 && arr[i+2] >=1){
                babyginCnt++;
                arr[i]-=1;
                arr[i+1]-=1;
                arr[i+2]-=1;
            }
        }

        if(babyginCnt==2){
            ans = true;
        }

        System.out.println("이 숫자 조합은 baby-gin인가?" + (ans ? "Yes" : "No") );
    }
}
