package SSAFY_Algo_0807;

import java.util.Scanner;

// 인접리스트
public class AdjListSearchTest_DFS {

    // 정점
    private static class Node {

        public int vertex;  // 정점 번호
        public Node link;  // 다음 연결된 정점

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node [vertex=" + vertex + ", link=" + link + "]";
        }
    }

    private static int V;  // 정점 개수
    private static Node[] adjList;  // 인접 리스트

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        adjList = new Node[V];

        int from, to;
        for (int i = 0; i < E; i++) {
            from = sc.nextInt();
            to = sc.nextInt();

            // 유향 그래프
            //adjList[from] = new Node(to, adjList[from]);

            // 무향 그래프
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);

        }

        // 인접행렬 출력
        //		for (int i = 0; i < V; i++) {
        //			for (int j = 0; j < V; j++) {
        //				System.out.print(adjMatrix[i][j] + " ");
        //			}
        //			System.out.println();
        //		}

        dfs(0, new boolean[V]);
    }

    // current: 현재 방문한 정점 번호
    // visited: 정점 방문 기록
    private static void dfs(int current, boolean[] visited) {

        // 방문처리
        visited[current] = true;

        // 방문한 정점에서 해야할 일 작성
        System.out.print((char) (current + 65) + " ");

        // 자신과 인접한 정점 방문
        for (Node temp = adjList[current]; temp != null; temp = temp.link) {

            if (!visited[temp.vertex]) {
                // 정점 i 방문
                dfs(temp.vertex, visited);
            }
        }
    }
}


