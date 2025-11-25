//package algorithm;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class codetree_숫자퍼즐모으기 {
//    private static boolean isSelected[];
//    private static int[][]arr;
//    private static int N,M;
//    private static int result;
//
//    public static void main(String[] args)throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        arr = new int[N][M];
//        isSelected = new boolean[N];
//
//        for(int i = 0; i< N; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j<M; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        result = Integer.MAX_VALUE;
//
//        subset(0);
//        if(result == Integer.MAX_VALUE)
//            result = -1;
//        System.out.println(result);
//
//    }
//
//    private static void subset(int cnt){
//
//        if(cnt == N){
//            ArrayList<Integer> list = new ArrayList<>();
//            for(int i = 0; i<N; i++){
//                if(isSelected[i]){
//                    list.add(i);
//                }
//
//                if(list.size() == 0){
//                    return;
//                }
//
//                int temp = findAns(list);
//                if(temp != -1){
//                    result = Math.min(result, temp);
//                }
//                return;
//            }
//        }
//
//        isSelected[cnt] = true;
//        subset(cnt+1);
//        isSelected[cnt] = false;
//        subset(cnt+1);
//    }
//
//    private static int findAns(ArrayList<Integer> list){
//
//        int count[] = new int[10];
//        int cnt = 0;
//
//        for(int row : list){
//            for(int j = 0; j < M; j++){
//                count[arr[row][j]]++;
//            }
//        }
//
//        for(int i = 0; i<10;i++){
//            if(count[i] > 0 )cnt++;
//        }
//        if(cnt == 10){
//            return list.size();
//        }else{
//            return -1;
//        }
//    }
//}
package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class codetree_숫자퍼즐모으기 {
    private static boolean[] isSelected;
    private static int[][] arr;
    private static int N, M;
    private static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;

        subset(0);

//        if (result == Integer.MAX_VALUE)
//            result = -1;

        System.out.println(result);
    }

    // 행 선택/비선택 부분집합 생성
    private static void subset(int cnt) {
        if (cnt == N) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    list.add(i);
                }
            }

            if (list.size() == 0) return;

            int temp = findAns(list);
            if (temp != -1) {
                result = Math.min(result, temp);
            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt + 1);

        isSelected[cnt] = false;
        subset(cnt + 1);
    }

    // 선택된 행들로 0~9를 다 만들 수 있는지 확인
    private static int findAns(ArrayList<Integer> list) {
        int[] count = new int[10];

        for (int row : list) {
            for (int j = 0; j < M; j++) {
                int num = arr[row][j];
                    count[num]++;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) cnt++;
        }

        if (cnt == 10) {
            return list.size();
        } else {
            return -1;
        }
    }
}