package SSAFY_Algo_0806;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetInputTest {
    private static int N; //총 원소의 개수.
    private static int totalCnt;
    private static int[]input;
    private static boolean[] isSelected;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        totalCnt = 0;
        input = new int[N];
        isSelected = new boolean[N];

        String[] split = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(split[i]);
        }

        generateSubset(0);
        System.out.println("총 경우의 수는 :" + totalCnt);

    }

    private static void generateSubset(int cnt){

        if(cnt == N){
            for(int i = 0; i< N ; i++){
                System.out.print((isSelected[i] ? input[i] : "X") + " ");
            }
            System.out.println();
            totalCnt++;
            return;
        }
        //유도 부분
        //첫번째 원소 선택 - 현재 원소를 부분집합에 포함.
        isSelected[cnt] = true;
        generateSubset(cnt+1);

        //현재 원소를 부분집합에 미포함
        isSelected[cnt] = false;
        generateSubset(cnt+1);

    }
}
