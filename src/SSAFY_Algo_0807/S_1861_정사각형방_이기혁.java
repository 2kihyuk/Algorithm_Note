package SSAFY_Algo_0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1861_정사각형방_이기혁 {

    private static int[][] arr;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    private static int N;

    public static void main(String[] args)throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //2
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());

           arr = new int[N][N];

           for(int i =0; i< N; i++){
               StringTokenizer st = new StringTokenizer(br.readLine());
               for(int j =0; j<N;j++){
                   arr[i][j] = Integer.parseInt(st.nextToken());
               }
           }
           int maxCount = 0;
           int room_num = Integer.MAX_VALUE;

           for(int i =0; i<N;i++){
               for(int j =0; j<N;j++){
                   int count = dfs(i,j,1);

                   if(count > maxCount){
                       room_num = arr[i][j];
                       maxCount = count;
                   }else if(count == maxCount){
                       room_num = Math.min(room_num,arr[i][j]);
                   }
               }
           }

            System.out.println("#" + test_case + " " + room_num + " " + maxCount);
        }
    }

    private static int dfs(int x, int y, int cnt){

        for(int i =0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >=0 && nextY >=0 && nextX < N && nextY < N){
                if(arr[nextX][nextY] == arr[x][y] + 1){
                    return dfs(nextX, nextY, cnt+1);
                }
            }
        }
        return cnt;
    }
}
