package 처음부터_20251202;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 덱_10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                q.offerLast(num);
            }else if(order.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                q.offerFirst(num);
            }else if(order.equals("pop_front")){
                if(!q.isEmpty()){
                    int num = q.pollFirst();
                    System.out.println(num);
                }else{
                    System.out.println(-1);
                }
            }
            else if(order.equals("pop_back")){
                if(!q.isEmpty()){
                    int num = q.pollLast();
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
