package algorithm;//package algorithm;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class codetree_십자모양의지속적폭발 {
//
//    private static int[]dx = {-1,1,0,0};
//    private static int[]dy = {0,0,-1,1};
//    private static int[][]arr;
//    private static int N,M;
//
//    public static void main(String[] args)throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        arr = new int[N][N];
//        for(int i = 0; i< N; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j<N; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        while(M-- > 0){
//            int col = Integer.parseInt(br.readLine());
//            int row = getRow(col);
//
//            if(row == -1) continue;
//            bomb(row,col);
//            gravity();
//        }
//
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0; i<N; i++){
//            for(int j = 0; j<N; j++){
//                sb.append(arr[i][j]).append(' ');
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);
//
//    }
//
//    private static int getRow(int col){
//        for(int r = 0; r<col; r++){
//            if(arr[r][col] > 0 )return r;
//        }
//        return -1;
//    }
//
//    private static void bomb(int x, int y){
//        int range = arr[x][y];
//        for(int i = 0; i<N; i++){
//            for(int j = 0; j<N; j++){
//                if((i == x || j == y) && Math.abs(i-x)+ Math.abs(j-y) < range){
//                    arr[i][j] = 0;
//                }
//            }
//        }
//
//    }
//    private static void gravity(){
//        for(int col = 0; col<N; col++){
//            int write = N-1;
//            for(int row = N-1; row>=0; row--){
//                if(arr[row][col] > 0){
//                    arr[write][col] = arr[row][col];
//                    if (write != row) arr[row][col] = 0;
//                    write--;
//                }
//            }
//            while (write >= 0) arr[write--][col] = 0;
//        }
//    }
//
//}
//
//
//
//
//
import java.io.*;
import java.util.*;

public class codetree_십자모양의지속적폭발 {

    static final int OUT = -1;
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        while (M-- > 0) {
            int col = Integer.parseInt(br.readLine()) - 1;

            int row = getRow(col);
            if (row == OUT) continue;

            bomb(row, col);
            gravity();
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    static int getRow(int col) {
        for (int r = 0; r < N; r++)
            if (arr[r][col] > 0) return r;
        return OUT;
    }

    static void bomb(int x, int y) {
        int range = arr[x][y];

        // 터뜨릴 위치 계산 후 0으로 세팅
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i == x || j == y) &&
                        Math.abs(i - x) + Math.abs(j - y) < range)
                    arr[i][j] = 0;
            }
        }
    }

    static void gravity() {
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
//        for (int col = 0; col < N; col++) {
//            int write = N - 1;
//
//            for (int row = N - 1; row >= 0; row--) {
//                if (arr[row][col] > 0) {
//                    arr[write][col] = arr[row][col];
//                    if (write != row) arr[row][col] = 0;
//                    write--;
//                }
//            }
//
//            while (write >= 0) arr[write--][col] = 0;
//        }
    }
}