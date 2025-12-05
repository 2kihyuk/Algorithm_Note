package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if(order.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }else if(order.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    int num = stack.pop();
                    System.out.println(num);
                }
            }else if(order.equals("size")){
                System.out.println(stack.size());
            }else if(order.equals("empty")){
                System.out.println(stack.isEmpty() ? 1 : 0);
            }else if(order.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
