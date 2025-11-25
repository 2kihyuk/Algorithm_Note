package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연구소_14502 {

    private static int N;
    private static int M;
    private static int [][]arr;

    private static int[]input;
    private static int[] numbers;
    private static ArrayList<int[]> list;
    private static ArrayList<int[]> virus;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    private static int ans;


    ///배열을 돌면서 , 2,1이 아닌 즉, 0인곳의 모든 좌표를 담아서, 모든 경우 중 3개의 경우를 뽑아 -> 조합으로.
    /// 해당 3개의 좌표에 벽을 세우고,
    /// 바이러스가 존재하는 곳부터 bfs를 돌릴 수 있을 만큼 돌리면서 배열을 바이러스화 시킨 후에, 0인곳의 수를 세며, 갱신 시키기.

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];


        list = new ArrayList<>();
        virus = new ArrayList<>();
        numbers = new int[3];


        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    list.add(new int[]{i,j});
                }
                if(arr[i][j] == 2){
                    virus.add(new int[]{i,j});
                }
            }
        }

        input = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            input[i] = i;
        }
        ans = Integer.MIN_VALUE;
        combination(0,0);


        System.out.println(ans);
    }

    private static void combination(int cnt, int start){

        if(cnt == 3){
            boolean[][] visited= new boolean[N][M];
            for(int a : numbers){
               //벽을 세울 공간의 좌표를 가져옴. 벽을 세우고.
                arr[list.get(a)[0]][list.get(a)[1]] = 1;
            }
            bfs(visited); //bfs 내에서 안전 영역을 갱신.

            int count = 0;
            for(int i = 0; i<N;i++){
                for(int j = 0; j<M;j++){
                    if(!visited[i][j] && arr[i][j] == 0){
                        count++;
                    }
                }
            }
            ans = Math.max(ans,count);

            for(int a : numbers){
                //벽을 다시 원상태로 복구하고.
                arr[list.get(a)[0]][list.get(a)[1]] = 0;
            }

            return;
        }

        for(int i = start; i <list.size();i++){
            numbers[cnt] = input[i];
            combination(cnt+1, i+1);
        }
    }
    private static void bfs(boolean[][] visited){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int[] v : virus){
            q.offer(new int[]{v[0], v[1]});
            visited[v[0]][v[1]] = true;
        }

//        //바이러스가 존재하는 시작점들에 대해서 모두 visited = true처리하고 시작.
        while(!q.isEmpty()){

            int current[] = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
             }
        }
    }


}
