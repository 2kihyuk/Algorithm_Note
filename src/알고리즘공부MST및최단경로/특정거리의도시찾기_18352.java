package 알고리즘공부MST및최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_18352 {
    private static int N,M,K,X;
    private static ArrayList<Integer>[] adjList;
    private static int[]dist;


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist,-1);

        for(int i = 0; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        bfs(X);

        boolean isFound = false;

        StringBuilder sb= new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }



    }

    private static void bfs(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : adjList[current]){
                if(dist[next] == -1){
                    dist[next] = dist[current] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
