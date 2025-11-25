package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {

    private static class Vertex implements Comparable<Vertex> {
        int to;
        int weight;

        public Vertex(int to, int weight){
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight,o.weight);
        }
    }

    private static int N; //정점
    private static int M; //간선
    private static ArrayList<Vertex>[] adjList;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Vertex(v,w));
            adjList[v].add(new Vertex(u,w));
        }

        int ans = prim(1);
        System.out.println(ans);

    }

    private static int prim(int start){

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(start,0));

        int total = 0;
        int count = 0;

        while(!pq.isEmpty() && count < N){
            Vertex current = pq.poll();
            if(visited[current.to]) continue;


            visited[current.to] = true;
            total += current.weight;
            count++;
            if(count == N){
                break;
            }

            for(Vertex next : adjList[current.to]){
                if(!visited[next.to]){
                    pq.offer(next);
                }
            }
        }
        return total;
    }
}
