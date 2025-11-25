package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_1차원윷놀이 {
    private static int n,m,k;
    private static int[]numbers;
    private static int ans ;
    private static int[] turn;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //턴의 수
        m = Integer.parseInt(st.nextToken()); //윷놀이 판의 상태
        k = Integer.parseInt(st.nextToken()); //말의 수

        st = new StringTokenizer(br.readLine());

        turn = new int[n];

        for(int i = 0; i<n; i++){
            turn[i] = Integer.parseInt(st.nextToken());
        }

        //말을 턴수대로 뽑아서 최대값?
        numbers = new int[n]; //4턴동안 몇번 말을 움직이게 할 것인가?
        ans = 0;
        dupl_permu(0);
        System.out.println(ans);

    }
    private static void dupl_permu(int cnt){
        if(cnt == n){
            game(); //윷놀이 게임 돌리기
            return;
        }

        for(int i = 1; i<=k;i++){
            numbers[cnt] = i;
            dupl_permu(cnt+1);
        }
    }

    private static void game(){

        int[] pos = new int[k+1]; //각 말의 위치
        for (int i = 1; i <= k; i++) pos[i] = 1;

        for(int t = 0; t<n;t++){
            int horse = numbers[t];
            pos[horse] += turn[t];
        }
        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (pos[i] >= m) count++; // 도착한 말 수 세기
        }
        ans = Math.max(ans,count);

    }
}
