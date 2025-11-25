package 알고리즘공부MST및최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로_1504 {
    //다익스트라는 모든 정점을 통과하지 않고서 시작점-도착점까지 최소 거리의 정점을 지나가고.
    //프림 크루스칼은 모든 정점을 통과하면서 mst를 그려나감.
    //근데 프림,크루스칼은 사이클이 생기면 안됨.

    //다익스트라로 가야하는데
    //1번에서 부터 N번정점까지 가면서 중간에 반드시 m1,m2정점을 들려야한다는 조건
    // 다익스트라를 3번 돌려야하는데 1번에서 시작해서 m1 / m1에서 시작해서 m2 / m2에서 시작해서 N번정점까지의 최단거리를 각각
    //dist,dist1,dist2 배열을 각각 생성해서
    //dist[m1] , dist1[m2] , dist2[N]값을 더하면 답.
    private static int N,E;
    private static class Edge implements Comparable<Edge>{
        int to, weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static ArrayList<Edge>[] adjList;

    private static int m1,m2;
    private static final long INF = (long)1e15;


    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i = 1; i<=N;i++){
            adjList[i] = new ArrayList<>();
        }


        for(int i = 0; i<E;i ++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to,weight));
            adjList[to].add(new Edge(from,weight));

        }

        st = new StringTokenizer(br.readLine());

        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());

        // 다익스트라 세 번
        long[] from1 = dijkstra(1);
        long[] fromM1 = dijkstra(m1);
        long[] fromM2 = dijkstra(m2);

        // 두 가지 경로 경우의 수
        long v1 = from1[m1] + fromM1[m2] + fromM2[N]; // 1 → m1 → m2 → N
        long v2 = from1[m2] + fromM2[m1] + fromM1[N]; // 1 → m2 → m1 → N

        long ans = Math.min(v1, v2);

        System.out.println(ans >= INF ? -1 : ans);
    }

    private static long[] dijkstra(int start) {
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (dist[curr.to] < curr.weight) continue;

            for (Edge next : adjList[curr.to]) {
                if (dist[next.to] > dist[curr.to] + next.weight) {
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.offer(new Edge(next.to, (int)dist[next.to]));
                }
            }
        }
        return dist;
    }
}