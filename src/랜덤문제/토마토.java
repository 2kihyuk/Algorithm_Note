package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 토마토 {
    private static int N,M;
    private static int[][]arr;
    private static boolean[][] visited;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    private static ArrayList<int[]> tomato;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited= new boolean[N][M];
        tomato = new ArrayList<>();

        for(int i = 0; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                 tomato.add(new int[]{i,j});
                }
            }
        }

        //list에 토마토 시작점 담았고, 이거 토대로 bfs돌려나가면서 하루가 지날때마다 상하좌우 애들거 익음 처리 해나가야하는데
        //-1인 애들은 미리 방문 처리를 해둬야하나?

        int day = bfs();

        for(int i = 0; i< N ; i++){
            for(int j = 0; j<M; j++){
                if(arr[i][j] == -1){
                    visited[i][j] = true;
                }
            }
        }

        boolean isZero = false;

        for(int i = 0; i<N; i++)
        {
            for(int j = 0 ; j<M; j++){
                if(!visited[i][j]){
                    isZero = true;
                    break;
                }
            }
        }

        System.out.println(isZero ? -1 : day);



    }
    private static int bfs() {

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int[]t : tomato){
            int tx = t[0];
            int ty = t[1];
            q.offer(new int[]{tx,ty});
            visited[tx][ty] = true;
        }
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s<size; s++){
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int i = 0; i<4; i++){
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(arr[nx][ny] == -1) continue;
                    if(visited[nx][ny]) continue;
                    if(arr[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            if(!q.isEmpty()){
                count++;
            }
        }
        return count;
    }
}
