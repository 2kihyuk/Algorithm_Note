package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bakjoon_27866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int index = Integer.parseInt(br.readLine());

        System.out.println(str.charAt(index-1));
    }
}
