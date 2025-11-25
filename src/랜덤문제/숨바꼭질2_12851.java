package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 숨바꼭질2_12851 {
    private static int N,M;
    private static int afterSec;
    private static int method;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //수빈
        M = Integer.parseInt(st.nextToken()); //동생


        int ans = bfs();

        System.out.println(ans);

    }
    private static int bfs(){

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[]visited = new int[100001];
        q.offer(N);
        visited[N] = 1;

        while (!q.isEmpty()){
            int now = q.poll();

            if(now == M) {
                return visited[now] -1;
            }

            int next1 = now + 1;
            int next2 = now - 1;
            int next3 = now * 2;

            if(next1 < 1000001 && visited[next1] == 0){
                visited[next1] = visited[now] + 1;
                q.offer(next1);
            }
            if(next3 < 1000001 && visited[next3] == 0) {
                visited[next3] = visited[now] + 1;
                q.offer(next3);
            }
            if(next2 > 0 && visited[next2] == 0){
                visited[next2] = visited[now] + 1;
                q.offer(next2);
            }
        }
        return -1;
    }
}
