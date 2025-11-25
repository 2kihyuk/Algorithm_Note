package A형연습;

import java.util.Scanner;

public class M_5650_핀볼게임 {

    static int[][] map; //N*N 크기의 배열 -1~ 10 각각의 의미하는 바가 있다더라.
    static int N, ans; //N은 5~100사이. ans : 최대 점수를 의미할거다.
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1}; //상하좌우
    static int[][] block = {
            {0,1,2,3}, //0번 블록은 그냥 버려.(상하좌우)
            {1,3,0,2}, //1번 블록 상하좌우 순으로 만났을떄
            {3,0,1,2}, //2번 블록 상하좌우 순으로 만났을떄
            {2,0,3,1}, //3번 블록 상하좌우 순으로 만났을떄
            {1,2,3,0}, //4번 블록 상하좌우 순으로 만났을떄
            {1,0,3,2}  //5번 블록 상하좌우 순으로 만났을떄
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 1; tc<=T;tc++){

            N = sc.nextInt();
            ans = 0; //점수가 0점일 수 도 있음.

            map =new int[N+2][N+2];
            for(int i =1; i<=N; i++){
                for(int j =1; j<=N;j++){
                    map[i][j] = sc.nextInt();
                }
            }//입력 끝.

            //5번 블록으로 둘러싸자.
            for(int i =0; i<N+1; i++){
                map[i][0] = map[i][N+1] = map[0][i] = map[N+1][i] = 5;
            }

            //모든 곳, 모든 방향 발사
            for(int i = 1; i<=N;i++){
                for(int j =1; j<=N;j++){
                    if(map[i][j] == 0){
                        for(int d = 0; d<4; d++){
                            shoot(i,j,d);
                        } //4방향 발사
                    }//빈 블록 체크
                }//모든 곳
            }
            System.out.println("#" + tc+ " " + ans);

        }
    }

    private static void shoot(int stX, int stY, int d) {
        int x = stX;
        int y = stY;

        int score = 0; //현재 점수 = 0;


        while(true){
            int nx = x + dx[d];
            int ny = y + dy[d]; //다음 좌표 구함.

            if(nx == stX && ny == stY || map[nx][ny] == -1){
                if(ans < score) //블랙홀 만나도 게임 점수 유지하기 위해.
                    ans = score;
                return;
            }//시작좌표에 도달했거나, 블랙홀을 만나면 게임 스탑.

            if(map[nx][ny] > 0){
              //블록을 만났다.
              if(map[nx][ny] < 6){
                  int blockNum = map[nx][ny];
                  d = block[blockNum][d];
                  score++;
              }else{
                  //웜홀 이라면
                  out : for(int i = 1; i<=N;i++){
                      for(int j =1 ;j<=N;j++){
                          if((nx != i || ny!=j) && map[i][j] == map[nx][ny]){
                              nx = i;
                              ny = j;
                              break out;
                          }
                      }
                  }//웜홀 찾기
              }//웜홀
            }

            x = nx;
            y = ny;

        }//게임 중
    }

}
