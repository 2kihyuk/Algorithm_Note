package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호_9012 {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {

            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean impossible = false;

            int count = 0;

            for(char c : line.toCharArray()){
                if(c == '('){
                    count++;
                }else{
                    count--;
                    if(count<0) {
                        impossible = true;
                        break;
                    }
                }
            }

            if(count!=0){
                impossible = true;
            }
            sb.append(impossible ? "NO" : "YES");
            sb.append('\n');

//            for (char c : line.toCharArray()) {
//
//                if (c == ')' && !stack.isEmpty()) {
//                    stack.pop();
//                } else if (c == ')' && stack.isEmpty()) {
//                    impossible = true;
//                    break;
//                } else {
//                    stack.push(c);
//                }
//
//            }
//            if(impossible){
//                sb.append("NO");
//            }else if(stack.isEmpty()){
//                sb.append("YES");
//            }else{
//                sb.append("NO");
//            }
//
//            sb.append('\n');

        }
        System.out.println(sb);
    }
}
