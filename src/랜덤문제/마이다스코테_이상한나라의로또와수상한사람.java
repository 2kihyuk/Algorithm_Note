package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 마이다스코테_이상한나라의로또와수상한사람 {
    //유토는 이상한 나라에 모험을 하러 갔다. 그러다가 돈이 떨어진 유토는 그 나라에서 유 명한 로또를 하려고 한다.
    // 이상한 나라의 로또는 1부터 N까지의 숫자가 쓰여져 있는 N 개의 공 중 에서 6개의 공을 뽑는다.
    // 유토는 수상한 사람이 주는 힌트를 주고 가능한 당 첨번호를 분석하려고 한다.
    //• N: 공의 개수
    //• 6sNs45
    // 뽑을 수 있는 경우의 수를 세자.

    //조합으로 N개중 6개 뽑는 경우의 수 세는 코드 간단하게.
    private static int answer;
    private static int N;
    private static int[]input;
    private static int[]numbers;
    private static int M;//절대 뽑히질 않은 공의 개수.
    private static int A[];

    private static boolean[]banned;

    public static void main(String[] args)throws Exception {
        answer = 0;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        numbers = new int[6];
        banned = new boolean[N+1];

        for(int x : A){
            banned[x] = true;
        }

        input = new int[N+1];
        for(int i =1; i<=N;i++){
            input[i] = i;
        }
        combination(0,1);

        System.out.println(answer);
    }
    private static void combination(int cnt, int start){
        if(cnt == 6){
            answer++;
            return;
        }

        for(int i = start; i<=N;i++){
            if(banned[i]) continue;
            numbers[cnt] = input[i];
            combination(cnt+1,i+1);
        }
    }

}
