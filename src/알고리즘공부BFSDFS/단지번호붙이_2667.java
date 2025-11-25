package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이_2667 {

    private static int N;
    private static int[][]arr;
    private static boolean[][]visited;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr =new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i<N;i++){
            String line[] = br.readLine().split("");
            for(int j = 0; j<N;j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    int count = bfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size()); // 단지 수 출력
        for(int a : list){
            System.out.println(a);
        }


    }

    private static int bfs(int x , int y) {

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        int count = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                if(arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    count++;
                }
            }
        }
        return count;

    }
}
