package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 세로읽기_10798 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][]arr = new char[5][15];
        for(int i = 0; i<5;i++){
            for(int j = 0; j<15;j++){
                arr[i][j] =' ';
            }
        }
        int max_len = -1;

        for(int i = 0; i<5;i++){
            String line = br.readLine();
            int len = line.length();
            max_len = Math.max(len,max_len);

            for(int j = 0; j<line.length(); j++){
                char c = line.charAt(j);
                arr[i][j] = c;
            }
        }

        for(int i = 0; i<max_len; i++){
            for(int j = 0; j<5;j++){
                char c = arr[j][i];
                if(c != ' '){
                    sb.append(c);
                }
            }
        }

        System.out.println(sb);





    }
}
