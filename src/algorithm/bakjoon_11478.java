package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bakjoon_11478 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<=n;j++){
                set.add(str.substring(i,j));
            }
        }

        System.out.println(set.size());


    }
}
