package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 코딩은체육과목입니다_25314 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int multi = N / 4;

        for(int i = 0; i<multi; i++){
            sb.append("long").append(" ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}
