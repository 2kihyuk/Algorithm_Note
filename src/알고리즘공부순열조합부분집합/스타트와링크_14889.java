package 알고리즘공부순열조합부분집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {
    private static int N;
    private static int [][]arr;
    private static int[] input;
    private static int[]numbers;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        input = new int[N];
        numbers = new int[N/2];

        StringTokenizer st;

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N;i++){
            input[i] = i;
        }

        combination(0,0);

        //조합
        System.out.println(ans);


    }
    private static void combination(int cnt, int start){

        if(cnt == N/2){

            ArrayList<Integer> pickList = new ArrayList<>();
            ArrayList<Integer> UnpickedList = new ArrayList<>();

            for(int i = 0; i<numbers.length;i++){
                pickList.add(numbers[i]);
            }//더할 인덱스를 pickList에 담았고,
            for(int i = 0; i<N;i++){
                if(!pickList.contains(input[i])){
                    UnpickedList.add(i);
                }
            }
            int pickSum = 0;
            int unPickSum = 0;
            for(int i = 0; i<pickList.size();i++){
                for(int j= i+1; j<pickList.size();j++){
                    int a = pickList.get(i);
                    int b = pickList.get(j);
                    pickSum+=(arr[a][b] + arr[b][a]);
                }
            }
            for(int i = 0; i<UnpickedList.size();i++){
                for(int j= i+1; j<UnpickedList.size();j++){
                    int a = UnpickedList.get(i);
                    int b = UnpickedList.get(j);

                    unPickSum+=(arr[a][b] + arr[b][a]);
                }
            }
            ans = Math.min(ans,Math.abs(pickSum-unPickSum));
            return;
        }

        for(int i = start; i<N;i++){
            numbers[cnt] = input[i];
            combination(cnt + 1, i+1);
        }
    }
}
