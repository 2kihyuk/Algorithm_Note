package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 단어의개수_1152 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        line = line.trim();

        String[] arr = line.split(" ");
        if(line.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(arr.length);
        }
    }
}
