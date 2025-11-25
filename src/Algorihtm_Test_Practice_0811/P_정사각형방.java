package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_정사각형방 {
    private static int[][] arr;
    private static int[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            visited = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int room_count = 0;
            int room_num = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                    visited = new boolean[N][N];

                    int count = dfs(i, j);
                    if (count > room_count) {
                        room_count = count;
                        room_num = arr[i][j];
                    } else if (count == room_count) {
                        if (arr[i][j] < room_num) {
                            room_num = arr[i][j];
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + room_num + " " + room_count);
        }
    }

    private static int dfs(int x, int y) {

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if (arr[nextX][nextY] == arr[x][y] + 1 ) {
                return dfs(nextX,nextY) + 1;
            }
        }
            return 1;
    }
}
