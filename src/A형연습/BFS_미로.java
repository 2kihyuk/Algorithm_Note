package A형연습;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BFS_미로 {

    private static boolean[][] visited;
    private static int[][]arr;
    //    private static StringTokenizer st;
    private static boolean isPossible;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for(int tc = 1; tc<=T;tc++){

            int tca = Integer.parseInt(br.readLine());
            arr = new int[16][16];
            visited = new boolean[16][16];

            int startX  = -1;
            int startY = -1;

            for(int i = 0; i< 16; i++){
                String line = br.readLine();

                for(int j=0; j<16;j++){
                    arr[i][j] = line.charAt(j) - '0';

                    if(arr[i][j] == 2){
                        startX = i;
                        startY = j;
                    }
                }
            }
            isPossible = false;
            visited[startX][startY] = true;
            bfs(startX, startY);
            System.out.println("#" + tc + " " + (isPossible ? 1 : 0));

        }

    }

    private static void bfs(int x , int y){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int current[] = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX < 0 || nextX >=16 || nextY < 0 || nextY >=16) continue;

                if(arr[nextX][nextY] == 3){
                    isPossible = true;
                    return;
                }
                if(arr[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    q.offer(new int[]{nextX,nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

    }
}
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class DFS_미로 {
//
//    private static int[][]arr;
//    private static boolean result;
//    private static boolean[][] visited;
//    private static int[]dx = {-1, 1, 0, 0};
//    private static int[]dy = {0, 0 , -1, 1};
//
//    private static int endX;
//    private static int endY;
//    public static void main(String[] args)throws Exception {
//
//        int T = 10;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        for(int test_case = 1; test_case <= 10; test_case++) {
//
//            int tc = Integer.parseInt(br.readLine());
//
//
//            arr= new int[16][16];
//            visited = new boolean[16][16];
//            for(int i = 0; i< 16; i++) {
//                String line = br.readLine();
//                for(int j = 0; j< 16; j++) {
//                    arr[i][j] = line.charAt(j) - '0';
//                }
//            }
//
//            int startX = 0;
//            int startY = 0;
//            endX = 0;
//            endY = 0;
//
//            for(int i = 0; i< 16; i++) {
//                for(int j = 0; j<16; j++) {
//                    if(arr[i][j] == 2) {
//                        startX =i;
//                        startY =j;
//                        break;
//                    }
//                }
//            }
//
//            for(int i = 0; i< 16; i++) {
//                for(int j = 0; j<16; j++) {
//                    if(arr[i][j] == 3) {
//                        endX = i;
//                        endY = j;
//                        break;
//                    }
//                }
//            }
//            //System.out.println(startX + " "+ startY + " " + endX + " "+ endY);
//
//            result = false;
//
//            visited[startX][startY] = true;
//
//            dfs(startX,startY);
//
//            System.out.println("#" + test_case+ " "+ (result ? "1" : "0"));
//
//
//        }
//    }
//    private static void dfs(int x, int y) {
//
////      if(x == endX && y == endY) {
////          result = true;
////          return;
////      }
//
//
//
//        for(int i =0; i<4; i++) {
//            int nextX = x + dx[i];
//            int nextY = y + dy[i];
//
//            if(nextX < 0 || nextX >=16 || nextY < 0 || nextY >=16) continue;
//
//            if(arr[nextX][nextY] == 3 ) {
//                result = true;
//                return;
//            }
//
//            if(arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
//                visited[nextX][nextY] = true;
//                dfs(nextX,nextY);
//            }
//        }
//
//    }
//}