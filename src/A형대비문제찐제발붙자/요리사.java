package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 요리사 {
    private static int N;
    private static int[][] arr;
    private static int[] numbers;
    private static int ans;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];

            numbers = new int[N/2];

            ans = Integer.MAX_VALUE;

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combi(0,0);
            System.out.println("#" + tc + " " + ans);
        }



    }

    private static void combi(int cnt, int start){

        if(cnt == N/2){

            ArrayList<Integer> listA = new ArrayList<>();
            ArrayList<Integer> listB = new ArrayList<>();

            for(int i = 0; i<numbers.length; i++){
                int a = numbers[i];
                listA.add(a);
            }
            for(int i = 0; i<N; i++){
                if(!listA.contains(i)){
                    listB.add(i);
                }
            }

            int tempA = getFood(listA);
            int tempB = getFood(listB);

            int tempAns = Math.abs(tempA - tempB);
            ans = Math.min(ans,tempAns);
            return;

        }

        for(int i = start; i<N; i++){
            numbers[cnt] = i;
            combi(cnt+1, i+1);
        }
    }

    private static int getFood(ArrayList<Integer> list){

        int len = list.size();
        int temp[] = new int[len];

        for(int i=0;i<len;i++){
            temp[i] = list.get(i);
        }

        int tempSum = 0;
        for(int i = 0; i<len-1; i++){
            for(int j = i+1; j<len;j++){
                tempSum += (arr[temp[i]][temp[j]] + arr[temp[j]][temp[i]]);
            }
        }

        return tempSum;
    }
}

