package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {
    private static int day,month , three_month,year;
    private static int[]arr;
    private static int ans;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){

            st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            three_month = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            ans = year;

            arr = new int[12];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<12; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            check(0,0);

            System.out.println("#" + tc+ " " + ans);

        }
    }
    private static void check(int cnt, int sum){


        if(cnt >= 12){
            ans = Math.min(ans, sum);
            return;
        }

        int now = arr[cnt];
        check(cnt + 1, sum + day * now);
        check(cnt + 1, sum + month);
        check(cnt + 3, sum + three_month);
    }
}
