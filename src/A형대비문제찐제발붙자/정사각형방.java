package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형방 {
    private static int N,T;
    private static int[][]arr;
    private static boolean[][] visited;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            int ans = Integer.MIN_VALUE;
            int room = -1;
            visited = new boolean[N][N];

            arr = new int[N][N];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    int result = dfs(i,j,1);
                    if(ans < result){
                        ans = result;
                        room = arr[i][j];
                    }else if(ans == result){
                        if(room > arr[i][j]){
                            room = arr[i][j];
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + room + " " + ans);
        }



    }

    private static int dfs(int x, int y, int cnt){

//        visited[x][y] = true;

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
//            if(visited[nx][ny]) continue;
            if(arr[nx][ny] == arr[x][y] + 1){
               return  dfs(nx,ny,cnt+1) ;
            }
        }
        return cnt;
    }
}
