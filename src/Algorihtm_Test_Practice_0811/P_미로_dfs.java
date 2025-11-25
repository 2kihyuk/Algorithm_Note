package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_미로_dfs {

    private static int[][] arr;
    private static boolean[][] visited;
    private static int startX;
    private static int startY;
    private static boolean result;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    private static boolean isFound;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            int t =  Integer.parseInt(br.readLine());

            arr= new int[16][16];
            visited = new boolean[16][16];

            for(int i = 0; i< 16; i++){
                String line = br.readLine();
                for(int j =0; j<16;j++){
                    arr[i][j] = line.charAt(j) -'0';
                }
            }

            for(int i = 0; i< 16; i++){
                for(int j =0; j<16;j ++){
                    if(arr[i][j] == 2){
                        startX = i;
                        startY = j;
                    }
                }
            }

            result = false;

            dfs(startX,startY);

            System.out.println("#" + test_case + " " + (result ? "1" : "0"));


        }
    }

    private static void dfs(int startX, int startY){

        visited[startX][startY] = true;

        for(int i =0; i<4; i++){
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >=16 || nextY >=16) continue;

            if(arr[nextX][nextY] == 3){
                result = true;
                return;
            }
            if(arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }

//    private static void dfs(int startX, int startY){
//
//        visited[startX][startY] = true;
//        if(arr[startX][startY] == 3){
//            result = true;
//            return;
//        }
//
//        for(int i =0; i<4; i++){
//            int nextX = startX + dx[i];
//            int nextY = startY + dy[i];
//
//            if(nextX < 0 || nextY < 0 || nextX >=16 || nextY >=16) continue;
//
//
//            if(arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
//                dfs(nextX, nextY);
//            }
//        }
//    }
}
