package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성 {

    private static int N;
    private static int K;
    private static int arr[][];
    private static int ans;
    private static int max;
    private static boolean[][] visited;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};


    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr= new int[N][N];
            visited = new boolean[N][N];

            max = Integer.MIN_VALUE;
            for(int i = 0; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max,arr[i][j]);
                }
            }

            ans = 0;
            for(int k = 1; k<=K;k++){
                for(int i =0; i<N;i++){
                    for(int j=0; j<N;j++){
                        arr[i][j]-=k;
                        find();
                        arr[i][j]+=k;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void find(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j< N;j++){
                if(arr[i][j] == max){
                    visited[i][j] = true;
                    dfs(i,j,1);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static void dfs(int x, int y,int cnt){

        ans = Math.max(cnt,ans);

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if(arr[x][y] > arr[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny,cnt+1);
                visited[nx][ny] = false;
            }
        }

    }
}
