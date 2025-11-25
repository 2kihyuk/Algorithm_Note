package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class M_미로탐색 {

    private static int[][] arr;
    private static boolean[][] visited;
    private static int N;
    private static int M;

    private static int[] dx= {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0; i<N; i++){
            String line[] = br.readLine().split("");
            for(int j =0; j<M;j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        visited[0][0]  = true;
        int ans = bfs(0,0 , 1);

        System.out.println(ans);
    }

    private static int bfs(int x, int y , int cnt){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y,cnt});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int current[] = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentLevel = current[2];

            if(currentX == N-1 && currentY == M-1){
                return currentLevel;
            }

            for(int i =0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >=M) continue;;

                if(arr[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    q.offer(new int[]{nextX,nextY,currentLevel+1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return cnt;
    }

}
