package 알고리즘공부MST및최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_1753 {

    private static int V,E,K;

    private static class Edge implements Comparable<Edge>{
        int to,weight;
        public Edge( int to, int weight){

            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static ArrayList<Edge>[] adjList;
    private static int[]dist;

    public static void main(String[] args)throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V+1];
        for(int i = 0; i<=V;i++ ){
            adjList[i] = new ArrayList<>();
        }

        dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);


        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to,weight));
        }

        dist[K] = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(K,0));

        while(!q.isEmpty()){

            Edge current = q.poll();

            int start = current.to;
            int startW = current.weight;

            if(dist[start] < startW) continue;

            for(Edge next : adjList[start]){
                if(dist[next.to] > startW + next.weight){
                    dist[next.to] = startW + next.weight;
                    q.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }




        for(int i = 1; i <= V; i++) { // V까지 순회
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }




    }
}
