package SSAFY_Algo_0812;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class S_3124_최소스패닝트리_이기혁
{

    private static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.weight - o.weight;
        }
    }

    private static Edge[] edgeList;
    private static int[]parents;
    private static int V;

    private static void makeSet() {
        parents = new int[V+1];
        for(int i = 0; i<=V;i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int a) {
        if(parents[a] == a) {
            return a;
        }

        return parents[a] = findSet(parents[a]);
    }

    private static boolean union(int a , int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) {
            return false;
        }
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E];

            for(int i = 0; i< E; i++) {
                st= new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from,to,weight);
            }

            Arrays.sort(edgeList);

            makeSet();

            long result = 0;
            int count = 0;

            for(Edge edge : edgeList) {
                if(union(edge.from,edge.to)) {
                    result+= edge.weight;
                    count++;
                    if(count == V-1) {
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);



        }
    }
}

