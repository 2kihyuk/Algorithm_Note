package algorithm;

import test.Parent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_십자모양폭발 {
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][]arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        r--;
        c--;

        int bomb = arr[r][c];
        arr[r][c] = 0;
        //r,c기준으로
        for(int i = 0; i<4; i++){
            for(int j=1; j<bomb; j++){
                int nx = r + dx[i]*j;
                int ny = c + dy[i]*j;

                if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
                arr[nx][ny] = 0;
            }
        }

       for(int i = 0; i < N; i++){
           for(int j = N-1; j>=0; j--){
               if(arr[j][i] == 0) continue;

               int down = j;
               while(down + 1 < N && arr[down+1][i] == 0){
                   int temp = arr[down+1][i];
                   arr[down+1][i] = arr[down][i];
                   arr[down][i] = temp;

                   down++;
               }
           }
       }

        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
