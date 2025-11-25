package 알고리즘공부구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연구소_14502 {

    private static int N,M;
    private static int [][]arr;

    private static int[] numbers;
    private static int[] input;

    private static ArrayList<int[]> emptyList;
    private static ArrayList<int[]> virus;
    private static int ans = Integer.MIN_VALUE;
    private static int dx[] = {-1,1,0,0};
    private static int dy[] = {0,0,-1,1};



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        emptyList = new ArrayList<>();
        virus = new ArrayList<>();

        for(int i = 0 ; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    emptyList.add(new int[]{i,j});
                }
                if(arr[i][j] == 2){
                    virus.add(new int[]{i,j});
                }
            }
        }


        numbers = new int[3];
        input = new int[emptyList.size()];
        for(int i = 0; i<emptyList.size();i++){
            input[i] = i;
        }



        combination(0,0);
        System.out.println(ans);

    }

    private static void combination(int cnt, int start){

        if(cnt == 3){
            boolean[][] visited = new boolean[N][M];
            for(int a : numbers){
                arr[emptyList.get(a)[0]][emptyList.get(a)[1]] = 1;
            }
            bfs(visited);

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
                arr[emptyList.get(a)[0]][emptyList.get(a)[1]] = 0;
            }
            return;
        }

        for(int i = start; i<input.length;i++){
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

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }
    }


}
