package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로_DFS {
    private static int[][]arr;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    private static boolean[][]visited;

    private static boolean ans;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for(int tc = 1; tc<=10; tc++){
            int t = Integer.parseInt(br.readLine());

            arr = new int[16][16];
            visited = new boolean[16][16];

            int startX = -1, startY = -1;

            for(int i = 0; i<16; i++){
                String line[] = br.readLine().split("");
                for(int j = 0; j<16; j++){
                    arr[i][j] = Integer.parseInt(line[j]);
                    if(arr[i][j] == 2){
                        startX = i;
                        startY = j;
                    }
                }
            }

            visited[startX][startY] = true;
//            ans = false;

            boolean ans = dfs(startX,startY);

            System.out.println("#" + tc + " " + (ans ? 1 : 0));

        }
    }

//    private static void dfs(int x, int y){
//
//
//        for(int i = 0; i<4; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//
//            if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16) continue;
//            if(arr[nx][ny] == 3){
//                ans = true;
//                return;
//            }
//            if(visited[nx][ny]) continue;
//
//            if(arr[nx][ny] == 0){
//                visited[nx][ny] = true;
//                dfs(nx,ny);
//            }
//
//        }
//    }

    private static boolean dfs(int x, int y){


        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16) continue;
            if(arr[nx][ny] == 3){
                return true;
            }
            if(visited[nx][ny]) continue;

            if(arr[nx][ny] == 0){
                visited[nx][ny] = true;
                if(dfs(nx,ny)) return true;
            }

        }
        return false;
    }
}
