package SSAFY_Algo_0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class S_1224_계산기3_이기혁 {
    public static void main(String[] args)throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case = 1; test_case <=T; test_case++){

            int N = Integer.parseInt(br.readLine());

            String str = br.readLine();
            Stack<Character> opStack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for(char c : str.toCharArray()){

                if(Character.isDigit(c)){
                    sb.append(c);
                }else {
                    if(c == '('){
                        opStack.push(c);
                    }else if(c == ')'){
                        while(!opStack.isEmpty() && opStack.peek() != '('){
                            sb.append(opStack.pop());
                        }
                        if(!opStack.isEmpty()){
                            opStack.pop();
                        }
                    }else if(c == '*'){
                        while(!opStack.isEmpty() && opStack.peek()== '*'){
                            sb.append(opStack.pop());
                        }
                        opStack.push(c);
                    }else if(c == '+'){
                        while(!opStack.isEmpty() && (opStack.peek()== '+' || opStack.peek()=='*')){
                            sb.append(opStack.pop());
                        }
                        opStack.push(c);
                    }
                }
            }

            while(!opStack.isEmpty()){
                sb.append(opStack.pop());
            }


            Stack<Integer> numStack = new Stack<>();

            for(int i =0; i<sb.length();i++){
                char c = sb.charAt(i);

                if(Character.isDigit(c)){
                    numStack.push(c-'0');
                }else {
                    if( c == '+'){
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        numStack.push(num2 + num1);
                    }else{
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        numStack.push(num2 * num1);
                    }
                }
            }

            System.out.println("#" + test_case +  " " + numStack.pop());
        }
    }
}
