package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_블랙잭{

    private static int N;
    private static int M;
    private static int[] input;
    private static int[] numbers;

    private static int ans;


    public static void main(String[] args)throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        input = new int[N];
        numbers = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        combi(0,0);

        System.out.println(ans);

    }

    private static void combi(int cnt, int start){

        if(cnt == 3){
            int sum = 0;
            for(int a : numbers){
                sum+=a;
            }
            if(sum <= M){
                ans = Math.max(ans,sum);
            }
            return;
        }

        for(int i = start; i<N;i++){
            numbers[cnt] = input[i];
            combi(cnt+1, i+1);
        }
    }
}
