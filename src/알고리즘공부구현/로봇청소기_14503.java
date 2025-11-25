package 알고리즘공부구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
    private static int N,M;
    private static int[][]arr;
    private static int[]dx = {-1,0,1,0}; //상,우,하,좌
    private static int[]dy = {0,1,0,-1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // r
        int y = Integer.parseInt(st.nextToken()); // c
        int dir = Integer.parseInt(st.nextToken()); // d

        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;


        while(true){
            //현재 칸이 청소되지 않았다면 청소한다. 0->2로 바꾼다.
            if(arr[x][y] == 0){
                arr[x][y] = 2;
                answer++; //청소횟수 ++
            }

            boolean moved =false;

            for(int i = 0; i<4; i++){
                dir = (dir + 3) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                    // 청소되지 않은 빈 칸이면 한 칸 전진
                    x = nx;
                    y = ny;
                    moved = true;
                    break; // 전진했으면 즉시 1번으로
                }
            }
            if(moved) continue;

            // 3) 4칸 모두 청소되어 있거나 벽인 경우 → 후진 시도 (방향 유지)
            int backX = x - dx[dir];
            int backY = y - dy[dir];

            if (backX < 0 || backX >= N || backY < 0 || backY >= M || arr[backX][backY] == 1) {
                System.out.println(answer);
                return;
            }
            // 벽이 아니면 한 칸 후진 (방향 유지)
            x = backX;
            y = backY;

    /*
    현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우.
    반시계 방향으로 90도 회전하고
    그 방향으로 1칸 앞이 청소되지 않았다면 그 칸 으로 이동후 청소.

    4칸중 청소되지 않은 빈칸이 없는경우. 2(이미 청소됨) 이거나 1(벽)인경우.
    바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 -> 2인경우에는 ->  한 칸 후진하고 1번으로 돌아간다.
    바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다. 1이면 isWall = true, isWall이면 break;로 끝.
     */

        }
    }
}
