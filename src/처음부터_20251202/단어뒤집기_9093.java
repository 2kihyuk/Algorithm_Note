package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 단어뒤집기_9093 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            char[] arr = line.toCharArray();

            for(char c : arr){
                if(c == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }else{
                    stack.push(c);
                }
            }
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            sb.append('\n');
        }

//        for(int i = 0; i<N; i++){
//            String line = br.readLine();
//            int len = line.length();
//            int left = 0;
//            int right = 0;
//
//            while(right < len){
//
//                if(line.charAt(right) == ' '){
//                    for(int j = right-1; j>=left; j--){
//                        sb.append(line.charAt(j));
//                    }
//                    sb.append(line.charAt(right));
//                    right++;
//                    left = right;
//                }else{
//                    right++;
//                }
//            }
//            for(int j = len-1; j>=left;j--){
//                sb.append(line.charAt(j));
//            }
//            sb.append('\n');
//        }
        System.out.println(sb);

//        for(int i = 0; i<N; i++){
//
//            String line = br.readLine();
//
//            char[] arr = line.toCharArray();
//            int idx = 0;
//            for(int j = 1; j<arr.length;j++){
//
//                if(arr[j]== ' '){
//                    for(int k = j-1; k>=idx;k--){
//                        sb.append(arr[k]);
//                    }
//                    sb.append(arr[j]);
//                    idx = j+1;
//                }
//            }
//
//            for(int j = arr.length-1; j>=idx;j--){
//                sb.append(arr[j]);
//            }
//
//            sb.append('\n');
//        }

    }
}
