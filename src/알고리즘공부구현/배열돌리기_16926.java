package 알고리즘공부구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 배열돌리기_16926 {
    private static int N,M,R;
    private static int[][]arr;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(N,M) / 2; //몇번할거냐?

        for(int layer = 0; layer<layers; layer++)
        {
            ArrayList<Integer> list = extract(layer); //
            Collections.rotate(list,-R);
            recovery(list,layer);

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        /*
        1 2 3 4
        5 6 7 8
        9 10 11 12
        13 14 15 16
         */

    }

    private static ArrayList<Integer> extract(int layer){
        ArrayList<Integer> list = new ArrayList<>();

        int top = layer;
        int left = layer;

        int bottom = N-1-layer;
        int right = M-1-layer;

        for(int i =left; i<=right;i++){
            list.add(arr[top][i]);
        }
        for(int i = top+1; i<=bottom; i++){
            list.add(arr[i][right]);
        }
        if(bottom > top){
            for(int i = right-1; i >= left; i--){
                list.add(arr[bottom][i]);
            }
        }
        if(right > left){
            for(int i = bottom-1; i>top; i--){
                list.add(arr[i][left]);
            }
        }
        return list;
    }
    private static void recovery(ArrayList<Integer>list, int layer){
        int top = layer;
        int left = layer;

        int bottom = N-1-layer;
        int right = M-1-layer;

        int idx = 0;
        for(int i =left; i<=right;i++){
            arr[top][i] = list.get(idx++);
        }
        for(int i = top+1; i<=bottom; i++){
            arr[i][right] = list.get(idx++);

        }
        if(bottom > top){
            for(int i = right-1; i >= left; i--){
                arr[bottom][i] = list.get(idx++);
            }
        }
        if(right > left){
            for(int i = bottom-1; i>top; i--){
                arr[i][left] = list.get(idx++);
            }
        }
    }
}
