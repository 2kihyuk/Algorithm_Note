package 알고리즘공부MST및최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197_크루스칼 {
    private static int V,E;

    private static class Edge implements Comparable<Edge>{
        int from,to,weight;
        public Edge(int from ,int to, int weight){
            this.from = from;
            this.to =to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int[]parent;
    private static Edge[] edgeList;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        edgeList = new Edge[E];


        for(int i = 0; i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from,to,weight);

        }
        Arrays.sort(edgeList);

        makeSet();
        int result = 0;
        int count = 0;
       for(Edge edge : edgeList){
           if(union(edge.from,edge.to)){
               result+=edge.weight;
               count++;
               if(count == V-1) break;
           }
       }
        System.out.println(result);



    }

    private static void makeSet(){
        parent = new int[V+1];
        for(int i = 1; i<=V;i++){
            parent[i] = i;
        }
    }
    private static int find(int a){

        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
    private static boolean union(int a , int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;
    }

}
