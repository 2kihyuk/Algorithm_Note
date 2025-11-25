package SSAFY_Algo_0805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class S_1210_Ladder1_이기혁 {

    static int arr[][];
    static boolean[][] visited;
    static int[] dx = {0,0,-1}; //좌, 우, 상
    static int[] dy = {-1,1,0}; //좌, 우, 상


    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int Test = Integer.parseInt(st.nextToken()); //1을 받음.

            arr = new int[100][100];

            for(int i =0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

           //visited = new boolean[100][100];

            int x = 99;
            int y = -1;


            for(int j =0; j<100; j++){
                if(arr[x][j] == 2){
                    y = j;
                    break;
                }
            }


            while(x > 0){

                if(y> 0 && arr[x][y-1] == 1){
                    //왼쪽 갈 수 있는지?
                    while(y > 0 && arr[x][y -1] == 1){
                        y--;
                    }
                }else if(y < 99 && arr[x][y+1] == 1){ //오른쪽 갈 수 있는지?
                    while(y < 99 && arr[x][y+1] == 1 ){
                        y++;
                    }
                }
                //이거 둘다 아니면 올라가기.
                x--;

            }

            System.out.println("#" + test_case + " " + y);

//            visited[x][y] = true;

//            int result = dfs(x,y);
//
//            System.out.println("#" + test_case + " " +result);
        }
    }

//    private static int dfs(int x, int y){
//
//
//        if(x == 0){
//           return y;
//        }
//
//        visited[x][y] = true; //방문처리를 해야하는건 맞는데, 이 위치가 기저 조건 위에 위치하면 코드 동작 이상하게 하는데 왜그럼?
//
//        for(int i =0; i<3;i++){
//            int nextX = x+dx[i];
//            int nextY = y+dy[i];
//
//            if(nextX < 0 || nextX >=100 || nextY < 0 || nextY >= 100) continue;
//            if(arr[nextX][nextY] !=0 && !visited[nextX][nextY]){
//                return dfs(nextX,nextY); ///이거 왜 return을 해야하는가? 원래 안하는데?
//            }
//        }
//        return -1;
//    }

}





//
//import java.util.Scanner;
//import java.io.FileInputStream;
//import java.util.*;
//
//class Solution
//{
//    public static void main(String args[]) throws Exception
//    {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int T = 10;
//
//        for(int test_case = 1; test_case <= T; test_case++)
//        {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            int Test = Integer.parseInt(st.nextToken()); //1을 받음.
//
//            int [][] arr = new int[100][100];
//
//            for(int i =0; i<100; i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j =0; j<100; j++){
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            int x = 99;
//            int y =0;
//
//            for(int i = 0; i<100; i++){
//                if(arr[x][i] == 2){
//                    y = i;
//                    break;
//                }
//            }
//
//            while(x > 0 ){
//
//                if(y > 0 && arr[x][y-1] == 1){ //좌
//                    while( y > 0 && arr[x][y-1] == 1){
//                        y--;
//                    }
//                }
//                else if( y< 99 && arr[x][y+1] ==1 ){
//                    while(y<99 && arr[x][y+1] == 1){
//                        y++;
//                    }
//                }
//                x--;
//            }
//            System.out.println("#" + test_case+ " " + y);
//
//        }
//
//    }
//}