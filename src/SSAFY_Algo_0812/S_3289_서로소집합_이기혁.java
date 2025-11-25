package SSAFY_Algo_0812;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_3289_서로소집합_이기혁 {
    static int[] parent;

    // Find 연산: 특정 원소가 속한 집합의 대표 원소(루트)를 찾는다.

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 재귀적으로 루트를 찾고, 부모를 루트로 갱신하여 경로를 압축한다.
        return parent[x] = find(parent[x]);
    }

    // Union 연산: 두 원소가 속한 집합을 하나로 합친다.
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // n+1 크기의 배열을 만들어 1부터 n까지의 인덱스를 사용
            parent = new int[n + 1];

            // 초기에 각 원소는 자신을 부모로 하는 개별 집합을 이룬다.
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            sb.append("#").append(t).append(" ");

            // m개의 연산을 처리
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int operation = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (operation == 0) {
                    // 합집합 연산
                    union(a, b);
                } else if (operation == 1) {
                    // 같은 집합 포함 여부 확인
                    if (find(a) == find(b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
