package SSAFY_Algo_0805;

import  java.util.*;

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//1부터 N까지 자연수 중에서 중복 없이 M개를  고른 수열
//고른 수열은 오름차순이어야 한다.

// -> 오름차순이어야 한다. 조합...
//만약 오름차순 조건이 없었다면, 순열이었을건데.

/*
* 원래 길이가 M인 수열을 구할때, 중복 없이 M개를 고른 수열이라는 것은,
*  */

public class M_15650_N과M2_이기혁 {

    static int N;
    static int M;

    static int[]numbers;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[M];

        sb= new StringBuilder();

        combination(0 , 1);
        ///0개의 데이터를 넣어둔 채로 조합 찾기 시작.
        ///1부터 시작하겠다.

        System.out.println(sb);
    }

    private static void combination(int cnt , int start){
        if(cnt == M){ //갯수가 M개가 완성되면, sb에 넣어 두기.
            for(int i =0; i<M;i++){
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<=N; i++){
            //start로 받아온 1부터 N까지 시작.
            numbers[cnt] = i;
            combination(cnt + 1 , i+1);

        }
    }
}
