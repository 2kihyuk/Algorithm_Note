package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 토마토_7576 {
    private static int N;
    private static int M;
    private static int[][]arr;
    private static boolean[][] visited;
    private  static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j =0; j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        int day = bfs(list);

        for(int i = 0; i<M; i++){
            for(int j = 0;j<N; j++){
                if(arr[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        boolean ans = true;

        for(int i = 0; i<M; i++){
            for(int j = 0;j<N; j++){
                if(!visited[i][j]) {
                    ans = false;
                    break;
                }
            }
        }

        System.out.println(ans ? day : -1);

    }

    private static int bfs(ArrayList<int[]> list){

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int[] a : list){
            int sx = a[0];
            int sy = a[1];
            visited[sx][sy] = true;
            q.offer(new int[]{sx,sy});
        }


        int count = 0;
        while(!q.isEmpty()){

            int size = q.size();

            for(int s = 0; s<size;s++){

                int current[] = q.poll();
                int cx = current[0];
                int cy = current[1];

                for(int i = 0; i<4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                    if(visited[nx][ny]) continue;
                    if(arr[nx][ny] == -1) continue;
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
