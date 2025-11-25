package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 숫자만들기 {

    private static int N;
    private static int numbers[];
    private static int opers[];
    private static StringTokenizer st;

    private static int maxResult;
    private static int minResult;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc<=T;tc++){
            N = Integer.parseInt(br.readLine().trim());

            numbers = new int[N];
            opers = new int[4];

            st = new StringTokenizer(br.readLine().trim());

            for(int i = 0; i<4;i++){
                opers[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for(int i = 0; i<N;i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            maxResult = Integer.MIN_VALUE;
            minResult = Integer.MAX_VALUE;

            calc(1,numbers[0]);
            System.out.println("#" + tc + " " + (Math.abs(maxResult - minResult)));

        }
    }

    //계산횟수.
    private static void calc(int calCnt , int value){

        if(calCnt == N){
            //계산 횟수가 숫자의 개수 라면 끝.
            minResult = Math.min(minResult,value);
            maxResult = Math.max(maxResult,value);
            return;
        }

        //opers에는 더하기,빼기,곱하기,나누기 순서로 각각 몇개 들어있는지.

        if(opers[0] > 0){
            opers[0]--;
            calc(calCnt+1, value + numbers[calCnt]);
            opers[0]++;
        }
        if(opers[1] > 0){
            opers[1]--;
            calc(calCnt+1, value - numbers[calCnt]);
            opers[1]++;
        }
        if(opers[2] > 0){
            opers[2]--;
            calc(calCnt+1, value * numbers[calCnt]);
            opers[2]++;
        }
        if(opers[3] > 0){
            opers[3]--;
            calc(calCnt+1, value / numbers[calCnt]);
            opers[3]++;
        }

    }

}
