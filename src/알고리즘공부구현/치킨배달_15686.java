package 알고리즘공부구현;

import test.Parent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686 {
    private static int N,M;
    private static int arr[][];
    private static ArrayList<int[]> chickenList = new ArrayList<>();
    private static ArrayList<int[]> homeList = new ArrayList<>();
    private static int chickenCnt = 0;
    private static int ans;

    private static int[]input;
    private static int[] numbers;

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];


        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    chickenList.add(new int[]{i,j});
                    chickenCnt++;
                }
                if(arr[i][j] == 1){
                    homeList.add(new int[]{i,j});
                }
            }
        }

        input = new int[chickenCnt];
        numbers = new int[M];

        for(int i = 0; i<chickenCnt;i++){
            input[i] = i;
        }


        ans = Integer.MAX_VALUE;
        if(M == chickenCnt){
            //한번에 계산
            ans = calculateDistanceOnetime();
        }else{
            combination(0,0);
        }

        System.out.println(ans);

    }

    private static void combination(int cnt, int start){
        if(cnt == M){
            //치킨집 M개 뽑아서 find 시작.
            ans = Math.min(ans,calculateDistance());
            return;
        }

        for(int i = start; i<chickenCnt;i++){
            numbers[cnt] = input[i];
            combination(cnt+1,i+1);
        }
    }


    private static int calculateDistance(){
        int sum = 0;
        for(int[]h : homeList){
            int hx = h[0];
            int hy = h[1];
            int best = Integer.MAX_VALUE;
            for(int i =0; i<M;i++){
                int[]c = chickenList.get(numbers[i]);
                int cx = c[0];
                int cy = c[1];
                int dist = Math.abs(hx-cx) + Math.abs(hy-cy);
                best = Math.min(best,dist);
            }
            sum+=best;
            //sum이 정답보다 크면 중단..
            if(sum >= ans) return sum;
        }
        return sum;
    }
    private static int calculateDistanceOnetime(){
        int sum = 0;
        for(int h[] : homeList){
            int hx = h[0];
            int hy = h[1];
            int best = Integer.MAX_VALUE;
            for(int i = 0; i<chickenCnt;i++){
                int[] c = chickenList.get(i);
                int d = Math.abs(hx - c[0]) + Math.abs(hy - c[1]);
                if (d < best) best = d;
            }
            sum+=best;
        }
        return sum;
    }

}
