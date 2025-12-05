package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 큐_10845 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
            }else if(order.equals("pop")){
                if(!q.isEmpty()){
                    int num = q.poll();
                    System.out.println(num);
                }else{
                    System.out.println(-1);
                }
            }else if(order.equals("size")){
                System.out.println(q.size());
            }else if(order.equals("empty")){
                System.out.println(q.isEmpty()?1:0);
            }else if(order.equals("front")){
                if(!q.isEmpty()){
                    System.out.println(q.peekFirst());
                }else{
                    System.out.println(-1);
                }
            }else if(order.equals("back")){
                if(!q.isEmpty()){
                    System.out.println(q.peekLast());
                }else{
                    System.out.println(-1);
                }
            }
        }
    }
}
