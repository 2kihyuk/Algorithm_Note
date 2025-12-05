package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숫자만들기 {
    private static int N;
    private static int[] opers;
    private static int[] numbers;
    private static boolean[] isSelected;
    private static int max,min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            opers = new int[4];
            numbers = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<4; i++){
                opers[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }


            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            dfs(numbers[0],1);

            System.out.println("#" + tc + " " + (max-min));


        }
    }

    private static void dfs(int value, int index){

        if(index == N){
            max = Math.max(max,value);
            min = Math.min(min,value);
            return;
        }

        int v= numbers[index];

        if(opers[0] > 0){
            opers[0]--;
            dfs(value + v,index+1);
            opers[0]++;
        }
        if(opers[1] > 0){
            opers[1]--;
            dfs(value - v, index+1);
            opers[1]++;
        }
        if(opers[2] > 0){
            opers[2]--;
            dfs(value * v, index+1);
            opers[2]++;
        }
        if(opers[3] > 0){
            opers[3]--;
            dfs(value / v, index+1);
            opers[3]++;
        }

    }
}
