package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_14510_나무높이_이기혁 {

    private static int min;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for(int test_case = 1; test_case <= T; test_case++){

            min = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine().trim()); //나무 개수

            int arr[] = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            for(int i = 0; i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }


            if(arr[N-1] == arr[0]){
                min = 0;
            }else{
                int diff = arr[N-1] - arr[0];

                int ans = diff / 3;
                int ans2 = diff % 3;

                min = ans * 2 + ans2 ;
            }




//            if(arr[N-1] == arr[0]){
//                min = 0;
//            }else{
//                dfs(arr[N-1], arr[0],0);
//            }

            System.out.println("#" + test_case + " " + min);
        }


    }

//    private  static void dfs(int big, int small, int cnt){
//        if(small > big){
//            return;
//        }
//
//        if(small == big){
//            min = cnt;
//            return;
//        }
//
//        dfs(big , small , cnt + 1);
//        dfs(big , small + 1 , cnt + 1);
//        dfs(big , small + 2 , cnt + 2);
//    }
}
