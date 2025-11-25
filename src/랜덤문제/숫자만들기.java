package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자만들기 {
    private static int N;
    private static int[]oper;
    private static int[]numbers;
    private static int maxResult;
    private static int minResult;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            oper = new int[4];
            for(int i = 0; i<4; i++){
                oper[i] = Integer.parseInt(st.nextToken());
            }

            //+-*/ 순서.

            numbers = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            maxResult = Integer.MIN_VALUE;
            minResult = Integer.MAX_VALUE;

            dfs(1,numbers[0]);

            System.out.println("#" + tc + " " + (maxResult - minResult));

        }
    }

    private static void dfs(int cnt, int current_value){
        if(cnt == N){
            maxResult = Math.max(maxResult,current_value);
            minResult = Math.min(minResult,current_value);
            return;
        }

        if(oper[0] > 0){
            oper[0]--;
            dfs(cnt+1,current_value + numbers[cnt]);
            oper[0]++;
        }
        if(oper[1] > 0){
            oper[1]--;
            dfs(cnt+1, current_value - numbers[cnt]);
            oper[1]++;
        }
        if(oper[2] > 0){
            oper[2]--;
            dfs(cnt+1, current_value * numbers[cnt]);
            oper[2]++;
        }
        if(oper[3] > 0){
            oper[3]--;
            dfs(cnt+1, current_value/numbers[cnt]);
            oper[3]++;
        }
    }
}
