package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 알바벳찾기_10809 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0; i<line.length();i++){
            list.add(line.charAt(i));
        }

        int[] alpha = new int[26];
        for(int i = 0; i<alpha.length;i++){
            alpha[i] = -1;
        }

        for(int i =0; i<list.size();i++){
            char c = list.get(i);
            int num = c -'a';
            if(alpha[num]== -1){
                alpha[num] = i;
            }else{
                continue;
            }
        }

        for(int i = 0; i<alpha.length;i++){
            System.out.print(alpha[i] + " ");
        }
    }
}
