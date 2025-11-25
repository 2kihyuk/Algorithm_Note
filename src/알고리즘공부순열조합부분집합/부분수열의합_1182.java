package 알고리즘공부순열조합부분집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {
    private static int N;
    private static int S;
    private static int[]input;
    private static boolean[] isSelected;
    private static int ans;


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        input = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        if (S == 0) ans--; // 공집합인 경우 1회 빼기
        subset(0);

        System.out.println(ans);
    }
    private static void subset(int cnt){

        if(cnt == N){
            int sum = 0;
            for(int i = 0; i<N;i++){
                if(isSelected[i]){
                    sum+=input[i];
                }
            }
            if(sum == S){
                ans++;
            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);

        isSelected[cnt] = false;
        subset(cnt+1);
    }
}
