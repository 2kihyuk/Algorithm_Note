package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1861_정사각형방_이기혁 {

    private static int N;
    private static int arr[][];
    private static StringTokenizer st;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args)throws  Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case<=T;test_case++){

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];


            for(int i = 0; i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max_count = 0;
            int max_room = Integer.MAX_VALUE;

            for(int i = 0; i< N; i++){
                for(int j = 0; j<N;j++){

                    int count = dfs(i,j,1);

                    if(count > max_count){
                        max_count = count;
                        max_room = arr[i][j];
                    }else if(count == max_count){
                        max_room = Math.min(max_room,arr[i][j]);
                    }
                }
            }
            System.out.println("#" + test_case + " " + max_room + " " + max_count) ;

        }
    }

//    private static int dfs(int x , int y ){
//
//        for(int i = 0 ; i<4; i++){
//            int nextX = x + dx[i];
//            int nextY = y + dy[i];
//
//            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
//            if(arr[nextX][nextY] == arr[x][y] + 1){
//                return dfs(nextX,nextY)+1 ;
//            }
//        }
//
//        return 1;
//    }
private static int dfs(int x , int y, int cnt ){

    for(int i = 0 ; i<4; i++){
        int nextX = x + dx[i];
        int nextY = y + dy[i];

        if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
        if(arr[nextX][nextY] == arr[x][y] + 1){
            return dfs(nextX,nextY,cnt+1) ;
        }
    }

    return cnt;
}
}
