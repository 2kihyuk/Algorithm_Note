package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성 {

    private static int N,K;
    private static int[][]arr;
    private static boolean[][] isVisited;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    private static int maxCnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            arr = new int[N][N];
            isVisited = new boolean[N][N];
            int maxHeight = -1;

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] > maxHeight){
                        maxHeight = arr[i][j];
                    }
                }
            }

            maxCnt = 0;
            for(int i = 0; i<N; i++){
                for(int j =0; j<N; j++){
                    if(arr[i][j] == maxHeight){
                        dfs(i,j , 1 ,true);
                    }
                }
            }

            System.out.println("#" + tc + " " + maxCnt);

        }
    }

    private static void dfs(int x, int y , int dist , boolean isPossible){

        if(dist > maxCnt){
            maxCnt = dist;
            return;
        }

        isVisited[x][y] = true;
        for(int i = 0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >=N || nextY >=N) continue;
            if(arr[nextX][nextY] < arr[x][y]){
                dfs(nextX,nextY,dist+1,isPossible);
            }else if(isPossible && arr[x][y] > arr[nextX][nextY] - K){
                int tmp = arr[nextX][nextY];
                arr[nextX][nextY] = arr[x][y] - 1;
                dfs(nextX,nextY,dist+1,false);
                arr[nextX][nextY] = tmp;
            }
        }

        isVisited[x][y] = false;
    }
}


//
//public class 등산로조성 {
//
//    private static int N,K;
//    private static int[][]arr;
//    private static boolean[][] isVisited;
//    private static int[]dx = {-1,1,0,0};
//    private static int[]dy = {0,0,-1,1};
//    private static int maxCnt;
//    private static int maxH;
//
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//
//        for(int tc = 1; tc <= T; tc++){
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            N = Integer.parseInt(st.nextToken());
//            K = Integer.parseInt(st.nextToken());
//
//
//            arr = new int[N][N];
//            isVisited = new boolean[N][N];
//
//            maxH = -1;
//
//            for(int i = 0; i<N;i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j = 0; j<N;j++){
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                    if(arr[i][j] > maxH){
//                        maxH = arr[i][j];
//                    }
//                }
//            }
//
//            maxCnt = 0;
//            find();
//
//            for(int k = 1; k<=K; k++){
//                for(int i = 0; i<N;i++){
//                    for(int j = 0; j<N;j++){
//                        arr[i][j] -=k;
//                        find();
//                        arr[i][j] +=k;
//                    }
//                }
//            }
//
//            System.out.println("#" + tc + " " + maxCnt);
//
//        }
//    }
//
//    private static void find(){
//        for(int i = 0; i<N;i++){
//            for(int j =0;j <N;j++){
//                if(arr[i][j] == maxH){
//                    isVisited[i][j] = true;
//                    dfs(i,j, arr[i][j], 1);
//                    isVisited[i][j] = false;
//                }
//            }
//        }
//    }
//
//    private static void dfs(int x, int y, int h, int pathCnt){
//
//        maxCnt = Math.max(maxCnt,pathCnt);
//
//        for(int i =0; i<4; i++){
//            int nextX = x + dx[i];
//            int nextY = y + dy[i];
//
//            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
//            if(isVisited[nextX][nextY]) continue;
//
//            isVisited[nextX][nextY] = true;
//            if(arr[nextX][nextY] < h){
//                dfs(nextX,nextY,arr[nextX][nextY] , pathCnt + 1);
//            }
//            isVisited[nextX][nextY] = false;
//        }
//    }
//}
