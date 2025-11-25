package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 미로탈출14923 {
    private static int N,M,Hx,Hy,Ex,Ey;
    private static int[][]arr;
    private static boolean[][][]visited;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    private static class Node{
        int x,y,wall,dist;
        Node(int x,int y, int wall, int dist){
            this.x = x;
            this.y= y;
            this.wall = wall;
            this.dist =dist;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken()) - 1;
        Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken()) - 1;
        Ey = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[N][M];
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    private static int bfs(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited = new boolean[N][M][2];
        q.offer(new Node(Hx,Hy,0,0));
        visited[Hx][Hy][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == Ex && cur.y == Ey){
                return cur.dist;
            }

            for(int i = 0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                //벽 안부수고 이동
                if(arr[nx][ny] == 0 && !visited[nx][ny][cur.wall]){
                    visited[nx][ny][cur.wall] = true;
                    q.offer(new Node(nx,ny,cur.wall,cur.dist+1));
                }

                if(arr[nx][ny] == 1 && cur.wall ==0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new Node(nx,ny,1,cur.dist+1));
                }
            }
        }
        return -1;
    }

}
