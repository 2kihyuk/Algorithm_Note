package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 요리사 {
    private static int N;
    private static int[][]arr;
    private static int[]numbers;
    private static int ans;


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            numbers = new int[N/2];

            for(int i = 0; i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0; j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = Integer.MAX_VALUE;
            //1부터N까지
            combination(0,0);

            System.out.println("#"+tc+" " + ans);
        }

    }
    private static void combination(int cnt, int start){

        if(cnt == N/2){
            ArrayList<Integer> pickList = new ArrayList<>();
            ArrayList<Integer> unPickedList = new ArrayList<>();
            for(int a : numbers){
                pickList.add(a);
            }
            for(int i = 0; i<N; i++){
                if(!pickList.contains(i)){
                    unPickedList.add(i);
                }
            }

            int pick = check(pickList);
            int unpick = check(unPickedList);

            int temp = Math.abs(pick-unpick);
            ans = Math.min(ans,temp);
            return;
        }

        for(int i = start; i<N;i++){
            numbers[cnt] = i;
            combination(cnt+1,i+1);
        }
    }
    private static int check(ArrayList<Integer> list){
        int len = list.size();
        int[]tempArr = new int[len];

        for(int i = 0; i<len; i++){
            tempArr[i] = list.get(i);
        }
        int tempSum = 0;
        //tempArr에는 리스트에서 뽑아낸 arr배열에서 뽑을 인덱스 값이 담겨있으니까
        for(int i = 0; i<len;i++){
            for(int j = i+1; j<len;j++){
                tempSum += (arr[tempArr[i]][tempArr[j]] + arr[tempArr[j]][tempArr[i]]);
            }
        }
        return tempSum;
    }

}
