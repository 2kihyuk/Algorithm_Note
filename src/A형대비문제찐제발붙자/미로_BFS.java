package A형대비문제찐제발붙자;

import test.Parent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 미로_BFS {
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;

    private static boolean ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());

            arr = new int[16][16];
            visited = new boolean[16][16];

            int startX = -1, startY = -1;

            for (int i = 0; i < 16; i++) {
                String line[] = br.readLine().split("");
                for (int j = 0; j < 16; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }


            ans = false;
            bfs(startX,startY);

            System.out.println("#" + tc + " " + (ans?1:0));
        }


    }

    private static void bfs(int x, int y){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16) continue;
                if(arr[nx][ny] == 3){
                    ans = true;
                    return;
                }
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] != 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }

    }

}
