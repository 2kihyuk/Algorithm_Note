package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 탈주범검거 {
    private static int N,M,R,C,L;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};

    private static int[][]arr;
    private static boolean[][] visited;
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); //가로
            M = Integer.parseInt(st.nextToken()); //세로
            R = Integer.parseInt(st.nextToken()); //맨홀 가로
            C = Integer.parseInt(st.nextToken()); //맨홀 세로
            L = Integer.parseInt(st.nextToken()); //소요 시간

            arr = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<M; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R,C);

            int ans = 0;

            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(visited[i][j]) ans++;
                }
            }
            System.out.println("#" + tc + " " + ans);


        }
    }
    private static void bfs(int x,int y){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y,1});

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i<size; i++){
                int cur[] = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                int cntTime = cur[2];

                if(cntTime == L) return;

                for(int d = 0; d<4; d++){
                    int nx = curX + dx[d];
                    int ny = curY + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                    if(visited[nx][ny]) continue;
                    switch (arr[curX][curY]){
                        case 1:
                            if(d == 0 && (arr[nx][ny] == 1 ||arr[nx][ny] == 2 || arr[nx][ny] == 5 || arr[nx][ny] == 6)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }
                            if(d == 1 && (arr[nx][ny] == 1 ||arr[nx][ny] == 2 || arr[nx][ny] == 4 || arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }
                            if(d == 2 && (arr[nx][ny] == 1 ||arr[nx][ny] == 3 || arr[nx][ny] == 4 || arr[nx][ny] == 5)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }
                            if(d == 3 && (arr[nx][ny] == 1 ||arr[nx][ny] == 3 || arr[nx][ny] == 6 || arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else{
                                break;
                            }
                        case 2:
                            if(d == 0 && (arr[nx][ny] == 2 ||arr[nx][ny] == 1 || arr[nx][ny] == 5 ||  arr[nx][ny] == 6 )){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else if(d == 1 && (arr[nx][ny] == 2 ||arr[nx][ny] == 1 || arr[nx][ny] == 4 || arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else {
                                break;
                            }
                        case 3:
                            if(d == 2 && (arr[nx][ny] == 3 ||arr[nx][ny] == 1 || arr[nx][ny] == 4 || arr[nx][ny] == 5)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else if(d == 3 && (arr[nx][ny] == 3 ||arr[nx][ny] == 1 || arr[nx][ny] == 6 || arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else{
                                break;
                            }
                        case 4:
                            if(d == 0 && (arr[nx][ny] == 1 || arr[nx][ny] == 2 || arr[nx][ny] == 5|| arr[nx][ny] == 6)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else if(d == 3 && (arr[nx][ny] == 1 || arr[nx][ny] == 3 || arr[nx][ny] == 6|| arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else {
                                break;
                            }
                        case 5:
                            if(d == 1 && (arr[nx][ny] == 1 || arr[nx][ny] == 2 || arr[nx][ny] == 4|| arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else if(d == 3 && (arr[nx][ny] == 1 || arr[nx][ny] == 3 || arr[nx][ny] == 6|| arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else {
                                break;
                            }
                        case 6:
                            if(d == 1 && (arr[nx][ny] == 1 || arr[nx][ny] == 2 || arr[nx][ny] == 4|| arr[nx][ny] == 7)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else if(d == 2 && (arr[nx][ny] == 1 || arr[nx][ny] == 3 || arr[nx][ny] == 4|| arr[nx][ny] == 5)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else {
                                break;
                            }
                        case 7:
                            if(d == 0 && (arr[nx][ny] == 1 || arr[nx][ny] == 2 || arr[nx][ny] == 5|| arr[nx][ny] == 6)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else if(d == 2 && (arr[nx][ny] == 1 || arr[nx][ny] == 3 || arr[nx][ny] == 4|| arr[nx][ny] == 5)){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny,cntTime+1});
                                break;
                            }else {
                                break;
                            }
                    }


                }
            }

        }



    }
}
