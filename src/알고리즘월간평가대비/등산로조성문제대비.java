package 알고리즘월간평가대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


///원래 등산로 조성 문제에서 , 최대 K값 만큼의 공사 조건을 제외하고, 최대 등산로 길이를 구하는 버전.
//
//public class 등산로조성문제대비 {
//
//    private static int N;
//    private static int[][]arr;
//    private static boolean[][] isVisited;
//    private static int[]dx = {-1,1,0,0};
//    private static int[]dy = {0,0,-1,1};
//    private static int maxCnt;
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
//
//            arr = new int[N][N];
//            isVisited = new boolean[N][N];
//            int maxHeight = -1;
//
//            for(int i = 0; i<N; i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j = 0; j<N;j++){
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                    if(arr[i][j] > maxHeight){
//                        maxHeight = arr[i][j];
//                    }
//                }
//            }
//
//            maxCnt = 0;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (arr[i][j] == maxHeight) {
//                        dfs(i, j, 1);
//                    }
//                }
//            }
//
//            System.out.println("#" + tc + " " + maxCnt);
//
//        }
//    }
//
//    private static void dfs(int x, int y , int dist ){
//
//         maxCnt = Math.max(dist,maxCnt);
//
//        isVisited[x][y] = true;
//
//        for(int i = 0; i<4; i++){
//            int nextX = x + dx[i];
//            int nextY = y + dy[i];
//
//            if(nextX < 0 || nextY < 0 || nextX >=N || nextY >=N) continue;
//               if(isVisited[nextX][nextY]) continue;
//            if(arr[nextX][nextY] < arr[x][y]) {
//                dfs(nextX, nextY, dist + 1);
//            }
//
//        }
//
//        isVisited[x][y] = false;
//    }
//}

// 2. 원래 등산로 조성 문제에서 가장 높은 봉우리에서 시작해야한다는 조건을 삭제한 문제.
public class 등산로조성문제대비 {

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
                }
            }

            maxCnt = 0;

            //모든 곳에서 시작하는 방문.
            for(int i = 0; i<N;i++){
                for(int j = 0; j<N; j++){

                    dfs(i,j,arr[i][j],1, true);
                }
            }

            System.out.println("#" + tc + " " + maxCnt);

        }
    }

    private static void dfs(int x, int y , int height, int count , boolean isPossibleFix){

        maxCnt = Math.max(maxCnt,count);

        isVisited[x][y] = true;

        for(int i = 0; i< 4; i++){
            int nextX = x+ dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >=N) continue;
            if(isVisited[nextX][nextY]) continue;

            if(arr[x][y] > arr[nextX][nextY]){
                dfs(nextX,nextY,arr[nextX][nextY], count+1,isPossibleFix);
            }else if(isPossibleFix && arr[nextX][nextY] -K < arr[x][y]){
                int tmp = arr[nextX][nextY];
                arr[nextX][nextY] = arr[x][y] - 1;
                dfs(nextX,nextY,arr[nextX][nextY] , count+1, false);
                arr[nextX][nextY] = tmp;
            }
        }
        isVisited[x][y] =false;
    }

}
