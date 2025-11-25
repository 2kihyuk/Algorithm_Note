package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_prim {

    private static int N,E;

    private static class Vertex implements  Comparable<Vertex>{
        int v;
        int weight;

        public Vertex(int v, int weight){
            this.v =v;
            this.weight =weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight ,o.weight);
        }
    }

    private static ArrayList<Vertex>[]adjList;


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[N+1];
            for(int i = 1; i<=N;i++){
                adjList[i] = new ArrayList<>();
            }

            for(int i = 0; i<E;i++){
                st= new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to= Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                adjList[from].add(new Vertex(to,weight));
                adjList[to].add(new Vertex(from,weight));
            }

            long result = prim();
            System.out.println("#" + tc + " " + result);

        }
    }

    private static long prim(){
        long totalWeight = 0;
        int vertexCount = 0;
        boolean [] visited= new boolean[N+1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        pq.offer(new Vertex(1,0));

        while(!pq.isEmpty()){
            Vertex current = pq.poll();
            int to = current.v;
            int weight = current.weight;

            if(visited[to]) continue;
            visited[to] = true;
            totalWeight+=weight;
            vertexCount++;

            if(vertexCount == N) break;

            for(Vertex next : adjList[to]){
                if(!visited[next.v]){
                    pq.offer(next);
                }
            }
        }
        return totalWeight;
    }

}
