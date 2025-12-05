package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 토마토 {
    private static int N,M,ans;
    private static int[][]arr;
    private static ArrayList<int[]> tomato;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        tomato = new ArrayList<>();
        visited = new boolean[N][M];

        int zero = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    tomato.add(new int[]{i,j});
                    zero++;
                }
                if(arr[i][j] == -1){
                    visited[i][j] = true;
                }

            }
        }

        bfs();

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!visited[i][j]){
                    ans = -1;
                    break;
                }else if(zero == N*M){
                    ans = 0;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
    private static void bfs(){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int count = 0;

        for(int[] t : tomato){
            int tx = t[0];
            int ty = t[1];
            q.offer(new int[]{tx,ty});
            visited[tx][ty] = true;
        }


        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i<size; i++){
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int d = 0; d<4; d++){
                    int nx = curX + dx[d];
                    int ny = curY + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                    if(visited[nx][ny]) continue; // -1인곳과 방문한 곳은 이미 visited true
                    if(arr[nx][ny] == 0){
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            if(!q.isEmpty()) count++;
        }
        ans = count;

    }
}
