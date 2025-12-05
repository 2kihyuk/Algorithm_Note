package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팰린드롬인지확인하기_10988 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int left = 0;
        int right = line.length()-1;
        boolean isPalindrome = true;

        while(left < right){
            if(line.charAt(left) == line.charAt(right)){
                left++;
                right--;
            }else{
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome?1:0);
    }
}
