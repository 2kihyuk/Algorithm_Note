package 알고리즘공부MST및최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197_프림 {

    private static int V,E;
    private static class Vertex implements Comparable<Vertex>{
        int to ,  weight;

        public Vertex(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }

    private static ArrayList<Vertex>[]adjList;
    private static boolean[]visited;

    public static void main(String[] args)throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[V+1];

        for(int i = 0; i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Vertex(to,weight));
            adjList[to].add(new Vertex(from,weight));

        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(1,0));

        int totalWeight = 0;
        int count = 0;

        while(!pq.isEmpty()){
            Vertex curr = pq.poll();

            if(visited[curr.to]) continue;
            visited[curr.to] = true;
            totalWeight+=curr.weight;
            count++;

            if(count == V) break;

            for(Vertex next : adjList[curr.to]){
                if(!visited[next.to]){
                    pq.offer(new Vertex(next.to,next.weight));
                }
            }
        }
        System.out.println(totalWeight);


    }
}
