package SSAFY_Algo_0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class M_일곱난쟁이_2309_이기혁 {

    private static int N;
    private static int M;
    private static int[] input;
    private static int[] numbers;

    // 정답을 찾았는지 여부를 나타내는 플래그
    private static boolean found = false;

    public static void main(String[] args)throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = 9;
        M = 7;

        input = new int[N];
        numbers = new int[M];

        for(int i =0; i<N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);
        combination(0,0);

    }

    private static void combination(int cnt, int start){

        if(found)
            return;

        if(cnt == M){
            int sum = 0;
            for(int h : numbers){
                sum+=h;
            }

            if(sum == 100){
                found = true;
                for(int a : numbers){
                    System.out.println(a);
                }
            }
            return;
        }

        for(int i = start; i<N; i++){
            numbers[cnt] = input[i];
            combination(cnt + 1 , i + 1);

            if(found){
                return;
            }
        }

    }
}


//        if( cnt == M ){
//            int sum = 0;
//            for(int i =0; i<numbers.length; i++){
//                sum+=numbers[i];
//            }
//            if(sum == 100){
//                for(int a : numbers){
//                    System.out.println(a);
//                }
//                return;
//            }else{
//                return;
//            }
//        }
//
//        for(int i = start; i<N;i++){
//            numbers[cnt] = input[i];
//            combination(cnt + 1, i+1);
//        }