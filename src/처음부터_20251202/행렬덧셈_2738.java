package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬덧셈_2738 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][]arr = new int[N][M];
        int[][]arr2 = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                sb.append(arr[i][j]+arr2[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
