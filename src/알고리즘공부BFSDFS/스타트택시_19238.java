package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타트택시_19238 {
    private static int N, M, fuel;
    private static int[][] arr;          // 0: 빈칸, 1: 벽, >=2: 승객ID
    private static boolean[][] visited;  // (보조용) 필요시 사용
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Passenger{
        int sx,sy,ex,ey;
        public Passenger(int sx,int sy, int ex, int ey){
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }
    }
    private static class Pick{
        int x,y,dist;
        public Pick(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static Passenger[] passengers;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        // 1-based 배열
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 0 or 1(벽)
            }
        }

        st = new StringTokenizer(br.readLine());
        int taxiX = Integer.parseInt(st.nextToken());
        int taxiY = Integer.parseInt(st.nextToken());

        passengers = new Passenger[M+2];
        // 승객을 2..M+1 ID로 매핑해서 시작 위치에 표시
        for (int id = 2; id <= M + 1; id++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            passengers[id] = new Passenger(sr, sc, er, ec);
            arr[sr][sc] = id; // 승객 위치에 id 배치
        }

        //승객을 M명 다 태울때까지..
        for(int i = 0; i<M; i++){

            Pick p = bfsToNearPassengers(taxiX,taxiY);

            if(p == null){
                System.out.println(-1);
                return;
            }

            int sx = p.x;
            int sy = p.y;
            int d1 = p.dist;

            int pid = arr[sx][sy];

            if(fuel < d1){
                System.out.println(-1);
                return;
            }

            fuel-=d1;
            taxiX = sx;
            taxiY = sy;
            arr[sx][sy] = 0;

            Passenger cur = passengers[pid];
            int d2 = bfsDistance(taxiX,taxiY,cur.ex,cur.ey);

            if(d2 == -1 || fuel < d2){
                System.out.println(-1);
                return;
            }
            fuel-=d2;
            fuel+=d2*2;
            taxiX = cur.ex;
            taxiY = cur.ey;
        }


        System.out.println(fuel);

    }

    private static Pick bfsToNearPassengers(int x, int y){
        int[][]dist = new int[N+1][N+1];
        for(int i = 1; i<=N; i++) Arrays.fill(dist[i],-1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        dist[x][y] = 0;

        int bestDist = Integer.MAX_VALUE;
        int bestX= -1,bestY = -1;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDist = dist[curX][curY];

            if(curDist > bestDist) break;

            if(arr[curX][curY] >=2){
                if(curDist < bestDist || (curDist == bestDist && (curX == bestX && curY == bestY))){
                    bestX = curX;
                    bestY = curY;
                    bestDist = curDist;
                }
            }

            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(arr[nx][ny] == -1) continue;
                if(dist[nx][ny] == -1)continue;
                dist[nx][ny] = dist[curX][curY] + 1;
                q.offer(new int[]{nx,ny});
            }
        }

        if(bestX == -1) return  null;
        return new Pick(bestX,bestY,bestDist);
    }

    private static int bfsDistance(int sx, int sy, int ex, int ey){
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == ex && c == ey) return dist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d], nc = c + dy[d];
                if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
                if (arr[nr][nc] == 1) continue; // 벽
                if (dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return -1;
    }
    }
