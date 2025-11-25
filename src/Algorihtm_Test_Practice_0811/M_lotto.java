package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M_lotto {

    private static int N;
    private static int []input;
    private static int[] numbers;
    private static StringBuilder sb;


    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        String line;

        while((line = br.readLine())!=null){
            if (line.equals("0")) { // "0"이 단독으로 있는 줄인지 확인
                break;
            }

            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());

            input = new int[N];
            numbers = new int[6];

            for(int i = 0; i<N;i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input); //사전순 출력을 위함.

            combi(0,0);
            sb.append("\n");
        }

        System.out.println(sb);


    }

    private static void combi(int cnt, int start){
        if(cnt == 6){
            for(int a : numbers){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<N;i++){
            numbers[cnt] = input[i];
            combi(cnt + 1, i + 1);
        }
    }
}
