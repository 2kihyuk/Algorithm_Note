package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class babygin_combi {

    private static int N;
    private static int M;
    private static int[] input;
    private static int[] numbers;
    private static int totalCnt;

    public static void main(String[] args)throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = 6;
        totalCnt = 0;

        input = new int[N];
        numbers = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0;i < N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        combi(0,0);

        System.out.println(totalCnt);

    }

    private static void combi(int cnt, int start){

        if(cnt == M){
            if(isBabyGin(numbers)){
                totalCnt++;
            }
            return;
        }

        for(int i =start; i<N;i++){
            numbers[cnt] = input[i];
            combi(cnt + 1, i + 1);
        }
    }

    private static boolean isBabyGin(int []numbers){
        int arr[] = new int[10];

        int babyginCnt = 0;
        boolean result = false;

        for(int a : numbers){
            arr[a]++;
        }

        for(int i =0; i<arr.length;i++){
            while(arr[i] >= 3){
                babyginCnt++;
                arr[i]-=3;
            }
        }

        for(int i =0; i<arr.length-2; i++){
            while(arr[i] >=1 && arr[i+1] >=1 && arr[i+2] >=1){
                babyginCnt++;
                arr[i]-=1;
                arr[i+1]-=1;
                arr[i+2]-=1;
            }
        }

        if(babyginCnt==2){
            result = true;
        }

        return result;
    }


}
