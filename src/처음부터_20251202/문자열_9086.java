package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열_9086 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            String line = br.readLine();

            char a = line.charAt(0);
            char l = line.charAt(line.length()-1);

            sb.append(a).append(l).append('\n');

        }
        System.out.println(sb);

    }
}
