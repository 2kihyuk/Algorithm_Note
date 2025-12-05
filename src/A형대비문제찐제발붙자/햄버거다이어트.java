package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트 {
    private static int N,L,ans;
    private static int[]calorie, score;
    private static boolean[]isSelected;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            calorie = new int[N];
            score = new int[N];
            isSelected = new boolean[N];

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); // 점수
                int c = Integer.parseInt(st.nextToken()); // 칼로리

                score[i] = s;
                calorie[i] = c;
            }

            ans = 0;

            subset(0);

            System.out.println("#" + tc + " " + ans);

        }
    }
    private static void subset(int cnt){

        if(cnt == N){
            int tempScore = 0;
            int tempCalorie = 0;
            for(int i = 0; i<N; i++){
                if(isSelected[i]){
                    tempScore += score[i];
                    tempCalorie += calorie[i];
                }
            }

            if(tempCalorie<=L){
                ans = Math.max(ans,tempScore);
            }

            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }
}
