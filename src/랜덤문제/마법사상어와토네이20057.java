package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이20057 {
    private static int N;
    private static int[][]arr;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0}; //왼 아래 오른 위
    private static int ans = 0;

    private static int[][]moveX = {
            {-1,1,-1,1,-1,1,-2,2,0,0}, //왼쪽 이동 기준일때 비율 x좌표
            {-1,-1,0,0,1,1,0,0,2,1,2,1}, //아래 이동 기준일때 비율 x좌표
            {-1,-1,-1,1,-1,1,-2,2,0,0}, //오른쪽 이동 기준일때 비율 x좌표
            {-1,-1,0,0,1,1,0,0,2,1}
    };
    private static int[][]moveY = {
            {1,1,0,0,-1,-1,0,0,-2,-1},//왼쪽 이동 기준일때 비율 y좌표
            {-1,1,-1,1,-1,1,-2,2,0,0}, //아래 이동 기준일때 비율 y좌표
            {-1,1,0,0,1,1,0,0,2,2,1}, //오른쪽 이동 기준일때 비율 y 좌표
            {-1,1,-1,1,-1,1,-2,2,0,0}
    };


    private static int[] per = {1,1,7,7,10,10,2,2,5,0};
    //a 위치 (왼쪽 기준). 남은 모래 전부 감.

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nx = N/2;
        int ny = N/2;
        int step = 1;
        int cnt = 0;
        int dir = 0;
        boolean done = false;

        while(true){
            if(dir ==4) dir = 0;
            for(int k = 0; k<step;k++){
                nx+=dx[dir];
                ny+=dy[dir];

                int sand = arr[nx][ny];
                if(sand > 0){
                    spread(nx,ny,dir,sand);
                }
                if(nx == 0 && ny == 0){
                    done = true;
                    break;
                }
            }
            if(done) break;

            //방향 전환을 해야해.
            cnt++;
            if(cnt == 2){
                cnt = 0;
                step++;
            }
            dir++;
        }
        System.out.println(ans);
    }
    private static void spread(int x, int y, int d, int ySand){

        arr[x][y] = 0;
        int spreadSand = 0; //비율로 날린 모래 누적합

        for(int i = 0; i<10; i++){
            int tx = x + moveX[d][i];
            int ty = y + moveY[d][i];

            if(i == 9){
                int remain = ySand - spreadSand;
                if (out(tx, ty)) {
                    ans += remain;
                } else {
                    arr[tx][ty] += remain;
                }
            }else{
                int moved = (ySand * per[i]) / 100;
                spreadSand+=moved;

                if(out(tx,ty)){
                    ans+=moved;
                }else{
                    arr[tx][ty] += moved;
                }
            }
        }
    }

    //격자 밖인지 체크
    private static boolean out(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }


}
