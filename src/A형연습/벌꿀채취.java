package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벌꿀채취 {

    private static int N; //N * N 크기의 꿀 배열.
    private static int M; //앞 선 순열로 뽑은 2개의 행에 대해서 . 몇개의 벌꿀을 모을건지.

    private static int C; //수집한 꿀의 최댓값 구할때, 꿀양의 제한선.

    private static int[] inputRows;
    private static boolean isSelectedRows[];

    private static int[] numbers;
    private static int[] RowsNumbers; //N개의 행중 2개 뽑을거.

    private static boolean isSelected[];
    private static int[] input;

    private static int[][] arr;

    private static int max;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()) ;
        for(int tc = 1; tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            for(int i =0; i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            inputRows = new int[N];
            isSelectedRows = new boolean[N];
            RowsNumbers = new int[2];

            numbers = new int[M];
            input = new int[N];
            isSelected = new boolean[N];

            max = Integer.MIN_VALUE;

            if(N >= M *2){
                //한줄에서 두명의 사람이 나눠서 채취할 수 있을 때.
                permutation(0);
            }else{
                //한명이 한줄에서 선택하게 만드는경우.
                //우선 행을 고르고, 행을 다 선택한 경우에 따라 최댓값을 구하기.
                permutation1(0);
            }

            System.out.println("#" + tc + " " + max);

        }

    }

    private static void permutation(int cnt){

    }


    //행 뽑기.
    private static void permutation1(int cnt){
        if(cnt == 2){
            //numbers에 담긴 0부터 N-1까지의 행번호를 골라서, 그 행번호를 가지고 순열 돌리기.
            int row1 = RowsNumbers[0];
            int row2 = RowsNumbers[1];
            int a = permutation2(row1,0);
            int b = permutation2(row2,0);
            int sum = a+b;
            max = Math.max(sum,max);
            return;
        }

        for(int i = 0; i<N;i++){
            if(isSelectedRows[i]) continue;

            RowsNumbers[cnt] = inputRows[i];

            isSelectedRows[i] = true;
            permutation(cnt+1);
            isSelectedRows[i] = false;

        }
    }

    private static int permutation2(int row,int cnt){

        //배열의 행번호를 가져왔으니, 해당 행의 N개 중 M개를 뽑아서 값 더한 값 리턴.
        if(cnt == M){
            int tempSum = 0;
            for(int a : numbers){
                tempSum+=arr[row][a];
            }
            if(tempSum > C){
                for(int i = 0 ; i<numbers.length;i++){

                }
            }
            return tempSum;
        }

        for(int i = 0 ; i<N;i++) {
            if(isSelected[i]) continue;

            numbers[cnt] = input[i];
            isSelected[i] = true;
            permutation2(row,cnt+1);
            isSelected[i] = false;
        }
            return 0;
    }
}
