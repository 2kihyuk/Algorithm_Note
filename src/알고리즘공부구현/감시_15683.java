package 알고리즘공부구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시_15683 {
    private static int N,M;
    private static int[][]arr;
    private static int answer = Integer.MAX_VALUE;

    private static ArrayList<CCTV> cctvList = new ArrayList<>();
    // 0: up, 1: right, 2: down, 3: left
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // 타입별 방향 세트
    static int[][][] DIRS = {
            {}, // dummy for 0 index (타입은 1~5)
            {{0},{1},{2},{3}},                 // type 1
            {{0,2},{1,3}},                     // type 2
            {{0,1},{1,2},{2,3},{3,0}},         // type 3
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}}, // type 4
            {{0,1,2,3}}                        // type 5
    };

    private static class CCTV{
        int x,y,type;
        CCTV(int x, int y, int type) { this.x = x; this.y = y; this.type = type; }
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[N][M];

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= arr[i][j] && arr[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, arr[i][j]));
                }
            }
        }

        dfs(0,arr);
        System.out.println(answer);

    }

    private static void dfs(int idx, int [][] cur){
        if(idx == cctvList.size()){
            answer = Math.min(answer,countBlind(cur));
            return;
        }

        CCTV cv = cctvList.get(idx);
        for(int[]dirs : DIRS[cv.type]){
            int[][]next = copy(cur);

            for(int d : dirs){
                watch(next,cv.x,cv.y,d);
            }
            dfs(idx+1,next);
        }
    }

    private static void watch(int[][] map, int x, int y, int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while(in(nx,ny) && map[nx][ny]!=6){
            if (map[nx][ny] == 0) map[nx][ny] = 7; // 감시 표시
            nx += dx[dir];
            ny += dy[dir];
        }
    }
    private static boolean in(int x , int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static int[][] copy(int[][]src){
        int[][] dst = new int[N][M];
        for (int i = 0; i < N; i++) dst[i] = src[i].clone();
        return dst;
    }
    private static int countBlind(int[][] map){
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0) cnt++;
        return cnt;
    }
}
