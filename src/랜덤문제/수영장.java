package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {
    private static int dayPrice,monthPrice,threemonthPrice,yearPrice;
    private static int[]arr;
    private static int ans;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            dayPrice = Integer.parseInt(st.nextToken());
            monthPrice = Integer.parseInt(st.nextToken());
            threemonthPrice = Integer.parseInt(st.nextToken());
            yearPrice = Integer.parseInt(st.nextToken());

            arr = new int[12];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<12; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ans = yearPrice;

            dfs(0,0);

            sb.append("#").append(tc).append(' ').append(ans).append('\n');

        }
        System.out.println(sb);
    }
    private static void dfs(int cnt, int value){

        if(cnt >= 12){
            ans = Math.min(ans,value);
            return;
        }

//        if(value >= ans){
//            return;
//        }

        int d = arr[cnt];
        dfs(cnt+1, value + d * dayPrice);
        dfs(cnt+1, value + monthPrice);
        dfs(cnt+3, value + threemonthPrice);

    }
}
