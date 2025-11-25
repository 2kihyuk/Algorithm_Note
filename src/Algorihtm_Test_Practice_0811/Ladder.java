package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder {

    private static boolean[][]visited;
    private static int[][] arr;
    private static int[]dx = {0,0,-1};
    private static int[]dy = {-1,1,0};
    private static int y;
    private static boolean isFound;
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            int T = Integer.parseInt(br.readLine());

            arr= new int[100][100];

            int startX = 99;
            int startY = -1;

            for(int i =0; i< 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j< 100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[100][100];

            //사다리 도착점(나한테는 출발점의 좌표)좌표 찾기.
            //x는 99 고정이고, y좌표만 찾기.
            for(int i =0; i<100;i++){
                if(arr[99][i] == 2){
                    startY = i;
                    break;
                }
            }

            //방법 1. dfs

            //int  y = dfs(startX,startY);
            isFound = false;
            dfs(startX,startY);
            System.out.println("#" + test_case + " " + y);

            //방법 2. while()로 그냥 구현하기.

//            while(startX > 0){
//
//                if(startY > 0 && arr[startX][startY-1] == 1){ //왼쪽 가능.
//                    while(startY > 0 && arr[startX][startY-1] == 1){
//                        startY--;
//                    }
//                }else if(startY < 99 && arr[startX][startY + 1] == 1){//오른쪽가능.
//                    while(startY  < 99 && arr[startX][startY +1] ==1){
//                        startY++;
//                    }
//                }
//                //둘다 아니면 올라가기
//                startX--;
//            }

//            System.out.println("#" + test_case + " " + startY);

        }
    }

    private static void dfs(int startX,int startY){

        if(isFound){
            return;
        }

        if(startX == 0){
            y = startY;
            isFound = true;
            return;
        }

        visited[startX][startY] = true;

        for(int i = 0; i<3; i++){
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if(nextX < 0 || nextY <0 || nextX > 99 || nextY > 99)continue;

            if(arr[nextX][nextY] == 1 && !visited[nextX][nextY]){
                dfs(nextX,nextY);
            }
        }
    }
//    private static int dfs(int startX , int startY){
//
//        if(startX == 0){
//            return startY;
//        }
//        visited[startX][startY] = true;
//
//        for(int i =0; i<3;i++){
//            int nextX = startX + dx[i];
//            int nextY = startY + dy[i];
//            //탐색할때 사다리 타는건 왼쪽 오른쪽 을 먼저 보고 그 위를 봐야함.
//
//            if(nextX < 0 || nextY < 0 || nextX > 99 || nextY > 99) continue;
//            if(arr[nextX][nextY] == 1 && !visited[nextX][nextY]){
//                return dfs(nextX,nextY);
//            }
//        }
//        return 1;
//    }
}
