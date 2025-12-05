package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성 {
    private static int N, K, ans;
    private static int[][]arr;
    private static boolean[][]visited;
    private static int max_Height;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            max_Height = 0;
            ans = Integer.MIN_VALUE;

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max_Height = Math.max(max_Height,arr[i][j]);
                }
            }

            check(); // 아예 깎지 않는 경우도 포함.

            for(int k = 1; k<=K; k++){
                for(int i = 0; i<N; i++){
                    for(int j = 0; j<N; j++){
                        arr[i][j]-=k;
                        check();
                        arr[i][j]+=k;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);

        }

    }

    private static void check(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(arr[i][j] == max_Height){
                    visited = new boolean[N][N];
                    visited[i][j] = true;
                    dfs(i,j,1);
                }
            }
        }
    }
    private static void dfs(int x, int y, int cnt){

        ans = Math.max(ans,cnt);

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;

            if(arr[nx][ny] < arr[x][y]){
                visited[nx][ny] = true;
                dfs(nx,ny,cnt+1);
                visited[nx][ny] = false; // 다른 경로도 봐야하니까!
            }
        }
    }
}
