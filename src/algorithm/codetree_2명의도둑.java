package algorithm;//package algorithm;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class codetree_2명의도둑 {
//    private static int N,M,C;
//    private static int[][]arr;
//    private static int[]numbers;
//    private static int ans;
//    private static boolean[][] isVisited;
//
//    public static void main(String[] args)throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        arr = new int[N][N];
//        numbers = new int[2]; //0부터 N-1까지 고르기.
//        ans = Integer.MIN_VALUE;
//
//        //도둑 두명이 M개의 열을 고를건데 겹치면 안된다.
//        //행이 같을때에는 겹쳐서는 안되며,
//        //행이 다를때도 겹치면 안되는구나. M개의 칸의 훔칠 물건의 합이 C이하여야하며, C를 초과하면 안된다. C와 값이 같다면 M개를 훔치지 않아도 괜찮다.
//        //우선 행부터 골라야하네. N개중 2개. 중복괜찮으니까 고르고,
//        //
//        for(int i = 0; i<N; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j<N; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        checkArea(0);
//
//        System.out.println(ans);
//    }
//
//    private static void checkArea(int cnt){
//        if(cnt == 2){
//            int aThief = numbers[0];
//            int bThief = numbers[1];
//            isVisited = new boolean[N][N];//방문 한 칸인지 체크.
//            int aResult = steal(aThief);
//            int bResult = steal(bThief);
//
//            int result = (int)Math.pow(aResult,2) + (int)Math.pow(bResult,2);
//            ans = Math.max(ans,result);
//            return;
//        }
//
//        for(int i = 0; i<N; i++){
//            numbers[cnt] = i;
//            checkArea(cnt+1);
//        }
//    }
//
//
//}
//
//
//
////private static int steal(int row){
////    //행 받아왔으니까, isVisited배열로 겹치지 않게 조절하면서 M개 만큼의 혹은 M개 이하면서 C값과 가장 가까운 최대값을 찾아서 리턴하기(해당행에서)
////
////    int max = Integer.MIN_VALUE;
////    int sum = 0;
////    int left = 0;
////    int right = 0;
////
////    while(true){
////        if(right == N) break;
////
////        if(isVisited[row][right]){
////            right++;
////            continue;
////        }
////        if(right-left == M){
////            max = Math.max(sum,max);
////        }
////
////        if(sum < C){
////            //sum이 C보다 작다면
////            sum+=arr[row][right];
////            isVisited[row][right] = true;
////            right++;
////        }else{
////            //sum이 C보다 크다면
////            sum-=arr[row][left];
////            isVisited[row][left] = false;
////            left++;
////        }
////
////
////    }
////
//////        for(int i = 0; i<N; i++){
//////            if(arr[row][i] == C){
//////                max = C;
//////                isVisited[row][i] = true;
//////                return max;
//////            }
//////        }
//////        int startIdx = 0;
//////
//////        for(int i = 0; i<N; i++){
//////            if(!isVisited[row][i]){
//////                startIdx = i;
//////            }
//////        }
//////
//////        for(int i = 0; i<M; i++){
//////            sum+=arr[row][i];
//////            isVisited[row][i] = true;
//////        }
//////
//////        max = sum;
//////        for(int i = M; i<N; i++){
//////            if(isVisited[row][i])continue;
//////            sum+=arr[row][i];
//////            isVisited[row][i] = true;
//////            sum-=arr[row][i-M];
//////            isVisited[row][i-M] = false;
//////            max = Math.max(max,sum);
//////        }
////    return max;
////}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_2명의도둑 {

    static int N, M, C;
    static int[][] arr;
    static int[][] value; // value[row][col] = (row, col~col+M-1) 구간에서 얻을 수 있는 최대 가치

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 각 (row, startCol)마다 최대 가치 미리 계산
        value = new int[N][N]; // col은 0 ~ N-M 까지만 유효

        for (int row = 0; row < N; row++) {
            for (int col = 0; col <= N - M; col++) {
                value[row][col] = calcMaxValue(row, col);
            }
        }

        // 2. 두 도둑의 구간 브루트포스
        int ans = 0;

        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 <= N - M; c1++) {

                for (int r2 = 0; r2 < N; r2++) {
                    for (int c2 = 0; c2 <= N - M; c2++) {

                        // 같은 행이면, 구간이 겹치면 안 됨
                        if (r1 == r2) {
                            int start1 = c1;
                            int end1 = c1 + M - 1;
                            int start2 = c2;
                            int end2 = c2 + M - 1;

                            // 겹치면 continue
                            if (!(end1 < start2 || end2 < start1)) {
                                continue;
                            }
                        }

                        int sumValue = value[r1][c1] + value[r2][c2];
                        if (sumValue > ans) {
                            ans = sumValue;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    // row행, col부터 M칸 구간에서 선택해서 얻을 수 있는 최대 가치 계산
    // 가치 = 선택한 칸들의 제곱합, 단 합 ≤ C
    private static int calcMaxValue(int row, int col) {
        int[] seg = new int[M];
        for (int k = 0; k < M; k++) {
            seg[k] = arr[row][col + k];
        }

        int best = 0;
        int totalMask = 1 << M;

        for (int mask = 0; mask < totalMask; mask++) {
            int sum = 0;
            int score = 0;

            for (int k = 0; k < M; k++) {
                if ((mask & (1 << k)) != 0) {
                    sum += seg[k];
                    if (sum > C) {
                        // 이미 C를 초과하면 더 볼 필요 없음
                        break;
                    }
                    score += seg[k] * seg[k];
                }
            }

            if (sum <= C && score > best) {
                best = score;
            }
        }

        return best;
    }
}