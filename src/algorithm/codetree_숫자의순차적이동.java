package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class codetree_숫자의순차적이동 {
    private static int[]dx = {-1,1,0,0,-1,-1,1,1};
    private static int[]dy = {0,0,-1,1,-1,1,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][]arr = new int[N][N];

        ArrayList<int[]>[]adjList = new ArrayList[(N*N)+1];
        for(int i = 1; i<=N*N; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                adjList[num].add(new int[]{i,j});
            }
        }

for(int t = 0; t<M; t++) {
    for (int i = 1; i <= N * N; i++) {

        int[] location = adjList[i].get(0);
        int locX = location[0];
        int locY = location[1];

        int bestX = locX;
        int bestY = locY;
        int bestVal = -1;

        for (int d = 0; d < 8; d++) {
            int nx = locX + dx[d];
            int ny = locY + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (bestVal < arr[nx][ny]) {
                bestVal = arr[nx][ny];
                bestX = nx;
                bestY = ny;
            }
        }

        adjList[bestVal].remove(0);
        adjList[bestVal].add(new int[]{locX, locY});
        adjList[i].remove(0);
        adjList[i].add(new int[]{bestX, bestY});

        int temp = arr[locX][locY];
        arr[locX][locY] = arr[bestX][bestY];
        arr[bestX][bestY] = temp;


    }
}

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
