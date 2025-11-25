package SSAFY_Algo_0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M_17135_캐슬디펜스_이기혁 {

    private static int N ;
    private static int M;
    private static int D;
    private static int [][]arr;

    private static int[] archer_combi_position;
    private static int maxKillCount; // 최종으로 죽인 킬 수.

    public static void main(String[] args)throws Exception {

        ///문제 정독 후 어떻게 풀어야 겠다 생각 한 부분 .

        ///5칸 중 3칸에 궁수를 배치하는건, 조합으로 5C3연산으로 가능 한 경우의수에 대해서,
        ///게임을 다 돌려 볼건데,
        /// 게임을 어떻게 돌릴거냐?

        ///사정거리가 존재하기때문에 열을 사정거리 만큼 쪼개서 , 해당 궁수 배치일떄, 칸만큼 bfs로 가까운 칸 부터 탐색해서
        ///1이면 성공한거라 카운트 늘려주면서 0으로 바꿔주는 갱신 작업을 한다.

        /// 이 작업을 5개 행이 존재할때 사거리가 2라면 , 12,23,34,45 행을 조사하면 된다..

        ///5c3 (3명의 궁수가 배치되는 모든 경우의 수) 에 대해서 bfs로 각 경우가 쏴서 죽일 수 있는 최대의 카운트 수를 세자!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        D = Integer.parseInt(str[2]);

        arr = new int[N][M];


        for(int i = 0; i< N ; i++){
            String st[] = br.readLine().split(" ");
            for(int j =0; j<M; j++){
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        combination(0,0);
        //여기서 조합 함수 호출.

        //조합 케이스 하나 완성되면 게임 스타트 함수 호출.

        //최종으로 최대 값 받아와서 리턴.


    }
    private static void combination(int cnt, int start){
        if(cnt == 3){
            gameStart();
            return;
        }

        for(int i = start; i<5; i++){
            archer_combi_position[cnt] = i;
            combination(cnt + 1, i+ 1);
        }
    }

    private static void gameStart(){
        ///archer_combi_position에 현재 궁수 3명이 각기 다른 포지션에 위치한 채 서있을때만 호출될거야 게임스타트 함수는.
        ///여기서 bfs로 돌려야하는데, 나 bfs까먹었어 수업듣고 나서 나머지 완성 가능할듯.
    }
}
