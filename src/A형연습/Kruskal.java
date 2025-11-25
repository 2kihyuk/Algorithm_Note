package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal {
    //간선리스트. 크루스칼. 유니온 파인드

    private static class Edge implements Comparable<Edge>{

        public int from,to,weight;
        public Edge(int from, int to, int weight){
            this.from =from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static Edge[]adjList;
    private static int[] parent;
    private static int N;
    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adjList = new Edge[E];

        for(int i =0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[i] = new Edge(from,to,weight);
        }

        Arrays.sort(adjList);

        for(int i = 0; i<N;i++){
            parent[i] = i;
        }
        int result = 0;
        int count = 0;

        for(Edge edge : adjList){
            if(union(edge.from,edge.to)){
                result+=edge.weight;
                if(++count == N-1){
                    break;
                }
            }
        }

        System.out.println(result);

    }


}
