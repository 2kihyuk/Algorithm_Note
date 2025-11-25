package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리_kruskal {

    private static int N;
    private static int E;

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    private static Edge[] edgeList;

    private static int[]parent;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E];

            for(int i = 0; i<E;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edgeList[i] = new Edge(from,to,weight);
            }

            Arrays.sort(edgeList, (a,b) -> a.weight - b.weight);

            makeSet();
            int ans = 0;
            int count = 0;

            for(Edge edge : edgeList){
                if(union(edge.to,edge.from)){
                    ans+=edge.weight;
                    count++;
                    if(count == N-1){
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);




        }
    }

    private static void makeSet(){
        parent = new int[N+1];
        for(int i = 0; i<=N;i++){
            parent[i] = i;
        }
    }
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;

    }
    private static int find(int a){
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
}
