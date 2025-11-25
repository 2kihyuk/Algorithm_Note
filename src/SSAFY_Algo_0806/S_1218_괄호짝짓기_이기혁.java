package SSAFY_Algo_0806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class S_1218_괄호짝짓기_이기혁 {

    public static void main(String[] args)throws Exception {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= T; test_case++){

            int N = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            int ans = 1;

            for(String s : str){
                if(s.equals("(") || s.equals("[") || s.equals("{") || s.equals("<")){
                    stack.push(s);
                }else if(s.equals(")")){
                    if(stack.isEmpty() || !stack.peek().equals("(")){
                        ans = 0;
                        break;
                    }
                    stack.pop();
                }else if(s.equals("]")){
                    if(stack.isEmpty() || !stack.peek().equals("[")){
                        ans = 0;
                        break;
                    }
                    stack.pop();

                }else if(s.equals("}")){
                    if(stack.isEmpty() || !stack.peek().equals("{")){
                        ans = 0;
                        break;
                    }
                    stack.pop();

                }else if(s.equals(">")){
                    if(stack.isEmpty() || !stack.peek().equals("<")){
                        ans = 0;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()){
                ans = 0;
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }
}
