package SSAFY_Algo_0807;
import java.util.*;
public class AdjMatrixSearchTest_DFS {

    private static int V; //정점 개수
    private static int[][] adjMatrix; //인접 행렬
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();

        int E = sc.nextInt(); //간선 개수.

        adjMatrix = new int[V][V];

        int from,to;
        //from은 시작정점, to는 도착정점

        for(int i = 0; i<E; i++){
            from = sc.nextInt();
            to = sc.nextInt();

            // 유향 그래프
//			adjMatrix[from][to] = 1;

            // 무향 그래프
            adjMatrix[to][from] = adjMatrix[from][to] = 1;

        }

        dfs(0, new boolean[V]);

    }

    // current: 현재 방문한 정점 번호
    // visited: 정점 방문 기록
    private static void dfs(int current, boolean[] visited){
        visited[current] = true;

        System.out.print((char) (current + 65) + " ");

        for(int i = 0; i<V; i++){
            if(adjMatrix[current][i] != 0 && !visited[i]){
                dfs(i,visited);
            }
        }
    }
}
