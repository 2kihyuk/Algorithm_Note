package SSAFY_Algo_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_햄버거다이어트_5215 {

    private static int N;
    private static int L;
    private static int[]scores; //재료별 점수
    private static int[]calories; //재료별 칼로리
    private static int maxScore; //최대 점수

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int testCase = 1; testCase <= T; testCase++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            scores = new int[N];
            calories = new int[N];
            maxScore = 0;

            for(int i = 0; i<N;i++){
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            combi(0,0,0);
            System.out.println("#" + testCase + " " + maxScore);
        }
    }

    private static void combi(int cnt , int currentScore, int currentCalorie){

        if(currentCalorie > L){
            return;
        }

        if(cnt == N){
            if(currentScore > maxScore){
                maxScore = currentScore;
            }
            return;
        }

        combi(cnt + 1, currentScore + scores[cnt] , currentCalorie + calories[cnt]);
        combi(cnt + 1, currentScore, currentCalorie);
    }
}
