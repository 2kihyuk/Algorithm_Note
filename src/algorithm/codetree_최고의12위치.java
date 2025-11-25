package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_최고의12위치 {
    private static int N,K,ans;
    private static int[][]arr;
    private static boolean[][] visited;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = -1;

        arr = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        findMax(0,0);

        System.out.println(ans);
    }

    private static void findMax(int cnt, int sum){

        ans = Math.max(ans,sum);

        if(cnt == K){
            return;
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){

                if(j+1 < N && !visited[i][j] && !visited[i][j+1]){
                    visited[i][j] = true;
                    visited[i][j+1] = true;
                    findMax(cnt+1, sum+arr[i][j]+arr[i][j+1]);
                    visited[i][j] = false;
                    visited[i][j+1] = false;
                }

                if(i+1 < N && !visited[i][j] && !visited[i+1][j]){
                    visited[i][j] = true;
                    visited[i+1][j] = true;
                    findMax(cnt+1, sum+arr[i][j]+arr[i+1][j]);
                    visited[i][j] = false;
                    visited[i+1][j] = false;
                }

            }
        }

    }

}
