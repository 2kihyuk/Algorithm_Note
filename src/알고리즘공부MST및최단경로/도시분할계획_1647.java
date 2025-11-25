package 알고리즘공부MST및최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획_1647 {

    //마을을 우선 크루스칼로 싹 다 만들고나서, 가장 가중치가 큰 간선을 하나 제외하면, 마을 하나를 빼는것과 같잖아.

    private static int N,M;
    private static int[] parent;
    private static class Edge implements Comparable<Edge>{
        int from,to,weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static Edge[] edgeList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeList = new Edge[M];

        for(int i =0; i<M; i++){

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from,to,weight);
        }

        makeSet();
        Arrays.sort(edgeList);

        int result = 0;
        int count = 0;
        int maxWeight = 0;

        for(Edge edge : edgeList){
            if(union(edge.from,edge.to)){
                result+=edge.weight;
                maxWeight = Math.max(edge.weight,maxWeight);
                count++;
                if(count == N-1)break;
            }
        }

        System.out.println(result - maxWeight);

    }

    private static void makeSet(){
        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }
    }

    private static int find(int a){
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;
    }
}
