package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 단어공부_1157 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int[26];

        String line = br.readLine();

        for(char c : line.toCharArray()){
            char cc = Character.toLowerCase(c);
            int num = cc-'a';
            alpha[num]++;
        }
        char ans;
        boolean no = false;

        int max = -1; //몇번 나왔는지
        int al = 0; //몇번째 알파벳인지
        for(int i =0; i<alpha.length;i++){
            if(max < alpha[i]){
                no = false;
                max = alpha[i];
                al = i;
            }else if(max == alpha[i]){
                no = true;

            }
        }
        if(no){
            System.out.println("?");
        }else{

            ans = (char)(al + 'a');
            ans = Character.toUpperCase(ans);

            System.out.println(ans);
        }

    }
}
