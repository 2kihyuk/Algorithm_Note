package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {

    //visited마지막인자 - 0이면 벽 안부숨ㅁ. 1이면 벽 부숨.
    private static class Node{
        int x,y,dist,broken;
        public Node(int x, int y, int dist, int broken){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    private static int N;
    private static int M;
    private static int[][]arr;
    private static boolean[][][]visited;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        visited = new boolean[N][M][2];

        for(int i = 0; i<N; i++){
            String line[] = br.readLine().split("");
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = bfs();

        System.out.println(ans);

    }

    private static int bfs(){
        ArrayDeque<Node> q= new ArrayDeque<>();

        q.offer(new Node(0,0,1,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == N-1 && now.y == M-1){
                return now.dist;
            }

            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(arr[nx][ny] == 0 && !visited[nx][ny][now.broken]){
                    visited[nx][ny][now.broken] = true;
                    q.offer(new Node(nx,ny,now.dist+1,now.broken));
                }

                if(arr[nx][ny] == 1 && now.broken == 0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new Node(nx,ny, now.dist +1, 1));
                }

            }
        }
        return -1;
    }



}
