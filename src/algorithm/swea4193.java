package algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class swea4193{

    static int N;
    static int[][] arr; // 맵 정보를 저장
    static int[][] dist; // 각 칸에 도착하는 최소 시간을 저장 (second 대신 dist로 이름 변경)
    // static boolean[][] visited; // 최소 거리(dist)를 사용하는 BFS에서는 일반적으로 필요 없음
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하
    static int[] dy = {0, 0, 1, -1}; // 우, 좌

    public static void bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[startX][startY] = 0;
        q.add(new int[]{startX,startY});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int curTime = dist[nowX][nowY];

            for(int i =0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                // 1인 경우
                if (arr[nextX][nextY] == 1) continue;

                int newTime;
                if (arr[nextX][nextY] == 0) {
                    newTime = curTime + 1; // 1초 소요
                }else{
                    // 2인 경우
                    //  이동하는 데 1초 소요
                    int arrivalTimeAtNextCell = curTime + 1;
                    int waitTime = 0;
                    //소용돌이는 3,6,9... 3의 배수일때만 지나갈 수 있음.
                    // 이동 후 도착할 시간이 3의 배수가 아니라면 대기해야 함
                    if (arrivalTimeAtNextCell % 3 != 0) {
                        waitTime = 3 - (arrivalTimeAtNextCell % 3);
                    }
                    newTime = arrivalTimeAtNextCell + waitTime; // 최종 소요 시간
                }

                // 현재까지 기록된 최소 시간보다 새로운 시간이 더 짧으면 업데이트
                if (dist[nextX][nextY] > newTime) {
                    dist[nextX][nextY] = newTime;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static void main(String[] args)throws  Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N][N];
            dist = new int[N][N]; // 'second' 대신 'dist'로 이름 통일

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // dist 배열을 최대값으로 초기화 (무한대 의미)
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            startX = sc.nextInt();
            startY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();

            // 시작점과 도착점이 같은 경우 시간은 0
            if (startX == endX && startY == endY) {
                System.out.println("#" + test_case + " " + 0);
            } else {
                bfs();
                // 도착 지점의 dist 값을 확인
                int ans = dist[endX][endY];

                // Integer.MAX_VALUE는 도착할 수 없음을 의미
                if (ans == Integer.MAX_VALUE) {
                    System.out.println("#" + test_case + " " + -1);
                } else {
                    System.out.println("#" + test_case + " " + ans);
                }
            }
        }
        sc.close();
    }
}



