package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복_2675 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int t  = Integer.parseInt(st.nextToken());
            String src = st.nextToken();

            for(int j = 0 ; j<src.length(); j++){
                char c = src.charAt(j);
                for(int x = 0; x<t; x++){
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
