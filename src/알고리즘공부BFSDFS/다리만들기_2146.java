package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 다리만들기_2146 {

    private static int N;
    private static int[][]arr;
    private static boolean[][] visited;

    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{

        //bfs로 섬을 찾아서 , 섬에 번호를 매겨두고, 각 섬마다 bfs로 최소 다리 길이를 모두 돌려보고 최소 값 찾기?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr=  new int[N][N];
        visited= new boolean[N][N];
        StringTokenizer st;
        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNum = 2;
        for(int i = 0; i<N; i++){
            for(int j =0; j<N;j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    labeling(i,j,islandNum);
                    islandNum++;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<N;i++){
            for(int j = 0; j<N;j++){
                if(arr[i][j] >= 2){
                     ans = Math.min(ans,bfs(i,j,arr[i][j]));
                }
            }
        }


        System.out.println(ans);
    }

    private static void labeling(int x, int y,int iNum){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        arr[x][y] = iNum;

        while(!q.isEmpty()){
            int c[] = q.poll();
            int cx = c[0];
            int cy = c[1];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx <0 || ny < 0 || nx >= N || ny >= N) continue;
                if(arr[nx][ny] ==0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                arr[nx][ny] = iNum;
                q.offer(new int[]{nx,ny});
            }
        }

    }

    private static int bfs(int x, int y, int islandNum){
        boolean [][] visited2 = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y,0});
        visited2[x][y] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int dist = current[2];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0|| ny <0 || nx >= N || ny >= N)continue;
                if(visited2[nx][ny]) continue;
                //같은 섬일때
                if(arr[nx][ny] == islandNum) continue;
                //바다 라면
                if(arr[nx][ny] == 0){
                    visited2[nx][ny ] = true;
                    q.offer(new int[]{nx,ny,dist+1});
                }else{
                    //다른 섬 만난 경우
                    return dist;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
