package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로 {

    private static int N;
    private static double E;
    private static int[]xL;
    private static int[]yL;
    private static StringTokenizer st;
    private static Vertex[]adjList;

    private static class Vertex implements Comparable<Vertex>{
        int no;
        long weight;

        public Vertex(int no, long weight){
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            xL = new int[N];
            yL = new int[N];
            for(int i = 0; i< N; i++){
                xL[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i< N; i++){
                yL[i] = Integer.parseInt(st.nextToken());
            }
            E = Integer.parseInt(br.readLine());

            System.out.println("#" + test_case + " " + Math.round(prim() * E));
        }
    }

    private static long prim(){
        long minEdge[] = new long[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(minEdge,Long.MAX_VALUE);

        minEdge[0] = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(0,0));

        long result = 0;
        int cnt = 0;

        while(!pq.isEmpty()){
            Vertex current = pq.poll();

            if(visited[current.no]) continue;
            visited[current.no] = true;

            result+= current.weight;
            if(++cnt == N) return result;

            for(int i = 0; i< N; i++){
                if(visited[i]) continue;
                long cost = getDist(xL[current.no], yL[current.no], xL[i], yL[i]);
                pq.offer(new Vertex(i, cost));
            }
        }
        return result;
    }

    private static long getDist(int x1, int y1, int x2, int y2) {
        long x = Math.abs(x2 - x1);
        long y = Math.abs(y2 - y1);
        return (x * x) + (y * y);
    }
}
