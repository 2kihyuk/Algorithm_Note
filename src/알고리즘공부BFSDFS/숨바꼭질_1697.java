package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {

    private static int N;
    private static int K;
    private static int count;
    private static int[] dist;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

         dist = new int[100001];
         Arrays.fill(dist,-1);

         if(N>=K){
             System.out.println(N-K);
         }else{
             System.out.println(bfs());
         }

    }

    private static int bfs(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[N] = 0;
        q.offer(N);

        while(!q.isEmpty()){
            int current = q.poll();

            if(current == K){
                return dist[current];
            }

            int nx1 = current +1;
            int nx2 = current -1;
            int nx3 = current *2;

            if(nx1 < 100001 && dist[nx1] == -1){
                dist[nx1] = dist[current] + 1;
                q.offer(nx1);
            }
            if(nx2 >= 0 && dist[nx2] == -1){
                dist[nx2] = dist[current] + 1;
                q.offer(nx2);
            }
            if(nx3 < 100001 && dist[nx3] == -1){
                dist[nx3] = dist[current] + 1;
                q.offer(nx3);
            }
        }
        return -1;
    }
}
