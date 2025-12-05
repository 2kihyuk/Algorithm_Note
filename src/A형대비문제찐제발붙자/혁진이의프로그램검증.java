//package A형대비문제찐제발붙자;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.StringTokenizer;
//
//public class 혁진이의프로그램검증 {
//    private static int N,M;
//    private static char[][] arr;
//    static class State {
//        int x, y, dir, mem;
//        State(int x, int y, int dir, int mem) {
//            this.x = x;
//            this.y = y;
//            this.dir = dir;
//            this.mem = mem;
//        }
//    }
//
//    private static int[]dx = {-1,1,0,0};
//    private static int[]dy = {0,0,-1,1};
//
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
//
//        for(int tc = 1; tc<=T; tc++) {
//            st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken());
//            M = Integer.parseInt(st.nextToken());
//
//            arr = new char[N][M];
//
//            for (int i = 0; i < N; i++) {
//                String line = br.readLine();
//                for (int j = 0; j < M; j++) {
//                    char c = line.charAt(j);
//                    arr[i][j] = c;
//                }
//            }
//
//            boolean result = bfs();
//
//
//            System.out.println("#" + tc + " " + (result ? "YES" : "NO"));
//
//        }
//        }
//        private static boolean bfs(){
//
//            boolean[][][][]visited = new boolean[N][M][4][16];
//            ArrayDeque<State> q = new ArrayDeque<>();
//
//            q.offer(new State(0,0,3,0));
//            visited[0][0][3][0] = true;
//
//            while(!q.isEmpty()){
//                State cur = q.poll();
//                int x = cur.x;
//                int y = cur.y;
//                int dir = cur.dir;
//                int mem = cur.mem;
//                char c = arr[x][y];
//
//                if(Character.isDigit(c)){
//                    mem = c-'0';
//                }else{
//                    switch (c){
//                        case '<': dir = 2; break;
//                        case '>': dir = 3; break;
//                        case '^': dir = 0; break;
//                        case 'v': dir = 1; break;
//                        case '_': // 메모리값이 0이면 오른쪽, 아니면 왼쪽
//                            dir = (mem == 0) ? 3 : 2;
//                            break;
//
//                        case '|': // 메모리값이 0이면 아래, 아니면 위
//                            dir = (mem == 0) ? 1 : 0;
//                            break;
//
//                        case '+':
//                            mem = (mem == 15) ? 0 : mem + 1;
//                            break;
//
//                        case '-':
//                            mem = (mem == 0) ? 15 : mem - 1;
//                            break;
//
//                        case '@':
//                            return true;
//
//                        case '?' :
//                            for(int nd = 0; nd < 4; nd++){
//                                int nx = (x+dx[dir] + N) % N;
//                                int ny = (y + dy[dir] + M) % M;
//
//
//                                if (!visited[nx][ny][nd][mem]) {
//                                    visited[nx][ny][nd][mem] = true;
//                                    q.offer(new State(nx, ny, nd, mem));
//                                }
//                            }
//                            continue;
//                        case '.' :
//                            break;
//                    }
//                }
//
//                int nx = (x+dx[dir] + N) % N;
//                int ny = (y+dy[dir] + M) % M;
//                if (!visited[nx][ny][dir][mem]) {
//                    visited[nx][ny][dir][mem] = true;
//                    q.offer(new State(nx, ny, dir, mem));
//                }
//            }
//            return false;
//        }
//    }
//
package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 혁진이의프로그램검증 {
    private static int N, M;
    private static char[][] arr;

    // 0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class State {
        int x, y, dir, mem;
        State(int x, int y, int dir, int mem) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mem = mem;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new char[N][M];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }

            boolean isDone = bfs();

            System.out.println("#" + tc + " " + (isDone ? "YES" : "NO"));
        }
    }

    // 프로그램이 @에 도달할 수 있으면 true, 아니면 false
    private static boolean bfs() {
        // visited[x][y][dir][memory]
        boolean[][][][] visited = new boolean[N][M][4][16];
        Queue<State> q = new ArrayDeque<>();

        // 시작 상태: (0,0), 방향 오른쪽(3), 메모리 0
        q.offer(new State(0, 0, 3, 0));
        visited[0][0][3][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int mem = cur.mem;

            char c = arr[x][y];

            // 현재 명령 처리
            if (c >= '0' && c <= '9') {
                mem = c - '0';
            } else {
                if (c == '<') {
                    dir = 2;
                } else if (c == '>') {
                    dir = 3;
                } else if (c == '^') {
                    dir = 0;
                } else if (c == 'v') {
                    dir = 1;
                } else if (c == '_') {
                    dir = (mem == 0) ? 3 : 2;
                } else if (c == '|') {
                    dir = (mem == 0) ? 1 : 0;
                } else if (c == '+') {
                    mem = (mem == 15) ? 0 : mem + 1;
                } else if (c == '-') {
                    mem = (mem == 0) ? 15 : mem - 1;
                } else if (c == '@') {
                    return true;  // 도착!
                } else if (c == '?') {
                    // 네 방향 모두 분기
                    for (int nd = 0; nd < 4; nd++) {
                        int nx = (x + dx[nd] + N) % N;
                        int ny = (y + dy[nd] + M) % M;

                        if (!visited[nx][ny][nd][mem]) {
                            visited[nx][ny][nd][mem] = true;
                            q.offer(new State(nx, ny, nd, mem));
                        }
                    }
                    // ?는 여기서 이동까지 처리했으니 다음 while로
                    continue;
                } else if (c == '.') {
                    // 아무것도 안 함 (그대로 진행)

                }
            }

            // 다음 위치로 한 칸 이동 (테두리에서 순간이동)
            int nx = (x + dx[dir] + N) % N;
            int ny = (y + dy[dir] + M) % M;

            if (!visited[nx][ny][dir][mem]) {
                visited[nx][ny][dir][mem] = true;
                q.offer(new State(nx, ny, dir, mem));
            }
        }

        return false; // 모든 상태 탐색했는데 @에 못 감
    }
}