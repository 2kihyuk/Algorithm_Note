package 알고리즘공부MST및최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {
    private static int N,M,X;
    private static class Node implements Comparable<Node> {
        int to, weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    private static ArrayList<Node>[] adjList;

    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i = 0; i<=N;i++){
            adjList[i] = new ArrayList<>();
        }


        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to,weight));
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 1; i<=N;i++){
            int go = check(i,X); //i번째 학생이 X까지 가는 비용.
            int arrival = check(X,i);//X에서 i로 돌아오는 비용.
            ans = Math.max(ans , go+arrival);
        }
        System.out.println(ans);

    }
    private static int check(int start,int end){
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.to] < now.weight) continue;

            for(Node next : adjList[now.to]){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist[end];
    }
}
