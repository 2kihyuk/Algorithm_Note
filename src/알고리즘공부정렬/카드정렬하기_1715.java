package 알고리즘공부정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {
    private static int N;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            q.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while(true){
            if(q.size()==1){
                break;
            }
            int a = q.poll();
            int b = q.poll();
            ans += (a+b);
            q.offer(a+b);
        }
        System.out.println(ans);
    }
}
