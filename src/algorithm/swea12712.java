package algorithm;

import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

class swea12712
{

    public static int check(int [][]arr , int i, int j , int N , int M , int dx[], int dy[]){
        int total = arr[i][j];
        for(int x = 1; x<M; x++){
            for(int y =0; y<4; y++){
                int nextX = i + dx[y] * x;
                int nextY = j + dy[y] * x;
                if(nextX >=0 && nextY >=0 && nextX < N && nextY < N){
                    total+=arr[nextX][nextY];
                }
            }
        }
        return total;
    }


    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int [][]arr = new int[N][N];

            for(int i =0; i<N;i++){
                for(int j =0; j<N;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int maxFlies = 0;
            int plusX[] = {-1,1,0,0};
            int plusY[] = {0,0,1,-1};
            int crossX[] = {-1,1,-1,1};
            int crossY[] = {-1,-1,1,1};

            for(int i =0; i<N;i++){
                for(int j =0; j<N;j++){
                    int plus = check(arr,i,j,N,M,plusX,plusY);
                    int cross = check(arr,i,j,N,M,crossX,crossY);
                    maxFlies = Math.max(maxFlies,Math.max(plus,cross));
                }
            }

            System.out.println("#" + test_case +  " " + maxFlies);

        }
    }
}