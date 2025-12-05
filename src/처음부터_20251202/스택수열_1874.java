package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        boolean possible = true;

        for(int i = 0 ; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > cur){
                for(int x = cur+1; x<=num; x++){
                    stack.push(x);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
                cur = num;
            }else{
                if(stack.isEmpty() || stack.peek()!=num){
                    possible = false;
                }else{
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }
        }

        if(possible){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}


//43687521

//push push push push pop pop push push pop push push pop pop pop pop pop