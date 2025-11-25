package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_방향에맞춰최대로움직이기 {

    private static int[] dx = new int[]{0,-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = new int[]{0,0, 1, 1, 1, 0, -1, -1, -1};
    private static int[][] arr;
    private static int[][] numbers;
    private static int N,r,c,ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i<N; i++){
            st =  new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numbers = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;


        ans = 0;

        //(r,c)에서 시작해서 해당 숫자에 해당하는 방향으로 쭉 가는데, 그 방향대로 격자를 벗어날 때 까지 가는데, 해당 칸의 수가 현재 있던 칸의 수보다 크다면 해당 칸으로 이동가능.
        // 그 이동한 칸의 써진 숫자대로 또 쭉가는데, 큰 숫자가 없으면 못가. 못갈때까지 최대 몇번 이동할 수있는가?
        //격자 범위를 벗어나지 않았으면서 더 갈 수 있는 곳이 없다면?

        dfs(r,c,0);

        System.out.println(ans);

    }
    private static void dfs(int x, int y, int cnt){

        ans = Math.max(ans,cnt);

        int curNum = arr[x][y];
        int curDir = numbers[x][y];

        for(int i = 0; i<N; i++){
            int nx = x + dx[curDir] * i;
            int ny = y + dy[curDir] * i;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            if(arr[nx][ny] > curNum){
                dfs(nx,ny,cnt+1);
            }

        }

    }
}


//while(true){
//
//            int curX = r;
//            int curY = c;
//
//            int curNum = arr[curX][curY];
//            int curDir = numbers[curX][curY];
//
//            int multi = 1;
//            boolean isRangeOut = false;
//
//           while(true){
//               int nx = curX + dx[curDir] * multi;
//               int ny = curY + dy[curDir] * multi;
//
//               if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
//               if(arr[curX][curY] > arr[nx][ny]){
//                   multi++;
//                   continue;
//               }
//
//           }
//
//        }

//import java.io.*;
//import java.util.*;
//
//public class codetree_방향에맞춰최대로움직이기 {
//
//    static int N;
//    static int[][] num;      // 각 칸의 숫자
//    static int[][] dir;      // 각 칸의 방향 (1~8)
//    static int ans;
//
//    // 1~8 방향: 위, 우상, 우, 우하, 하, 좌하, 좌, 좌상
//    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
//    static int[] dy = {0,  0,  1, 1, 1, 0,-1,-1, -1};
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        num = new int[N][N];
//        dir = new int[N][N];
//
//        StringTokenizer st;
//
//        // 숫자 배열
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                num[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 방향 배열
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                dir[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 시작 위치 (1-index → 0-index)
//        st = new StringTokenizer(br.readLine());
//        int r = Integer.parseInt(st.nextToken()) - 1;
//        int c = Integer.parseInt(st.nextToken()) - 1;
//
//        ans = 0;
//        dfs(r, c, 0);
//
//        System.out.println(ans);
//    }
//
//    private static void dfs(int x, int y, int cnt) {
//        // 현재까지 이동 횟수로 답 갱신
//        ans = Math.max(ans, cnt);
//
//        int curVal = num[x][y];
//        int curDir = dir[x][y];
//
//        // 현재 방향으로 1칸, 2칸, ... 계속 나가보면서
//        // 나보다 큰 숫자가 있는 칸들로만 재귀 호출
//        for (int step = 1; ; step++) {
//            int nx = x + dx[curDir] * step;
//            int ny = y + dy[curDir] * step;
//
//            // 격자 밖 나가면 더 이상 이 방향으로 못 감
//            if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
//
//            // 나보다 큰 숫자인 칸에만 이동 가능
//            if (num[nx][ny] > curVal) {
//                dfs(nx, ny, cnt + 1);
//            }
//        }
//    }
//}