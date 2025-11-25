package SSAFY_Algo_0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S_1234_비밀번호_이기혁 {

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            Stack<Character> stack = new Stack<>();

            for(int i =0; i<str.length();i++){
                char c = str.charAt(i);

                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }

            StringBuilder sb= new StringBuilder();

            for(char c : stack){
                sb.append(c);
            }

            System.out.println("#" + test_case + " " + sb);


        }
    }
}
