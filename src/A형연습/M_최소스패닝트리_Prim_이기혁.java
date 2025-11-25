package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class M_최소스패닝트리_Prim_이기혁 {

    private static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int N; //간선의 개수
    private static ArrayList<Edge>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <=T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            visited = new boolean[N+1];
            adjList = new ArrayList[N+1];
            for(int i = 1; i<=N;i++){
                adjList[i] = new ArrayList<>();
            }

            for(int i =0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                adjList[from].add(new Edge(to,weight));
                adjList[to].add(new Edge(from,weight));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            int result = 0; //가중치의 총합
            int count = 0; //선택된 간선의 수

            visited[1] = true;

            for(Edge edge : adjList[1]){
                pq.offer(edge);
            }

            while(!pq.isEmpty()){

                Edge edge = pq.poll();
                if(visited[edge.to]){
                    continue;
                }

                visited[edge.to] = true;
                result += edge.weight;
                count++;

                if(count == E){
                    break;
                }

                for(Edge nextEdge : adjList[edge.to]){
                    if(!visited[nextEdge.to]){
                        pq.offer(nextEdge);
                    }
                }
            }
            System.out.println(result);
        }
    }
}
