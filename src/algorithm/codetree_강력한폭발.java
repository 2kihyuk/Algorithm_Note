package algorithm;

import java.util.Scanner;

public class codetree_강력한폭발 {

    private static int ans;
    private static int n;
    private static int grid[][];
    private static int bombCnt;
    private static int[]numbers;

    private static int[][][]bomb = new int[][][]{
            {},
            {{-2,-1,1,2}, {0,0,0,0}},
            {{-1,1,0,0}, {0,0,-1,1}},
            {{-1,-1,1,1}, {-1,1,-1,1}},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Please write your code here.
        ans = Integer.MIN_VALUE;
        bombCnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    bombCnt++;
                }
            }
        }
        numbers = new int[bombCnt];

        checkBombArea(0);

        System.out.print(ans);


    }

    private static void checkBombArea(int cnt){

        if(cnt == bombCnt){
            int tempBombCnt = bomb();
            ans = Math.max(ans,tempBombCnt);
            return;
        }

        for(int i = 1; i<=3; i++){
            numbers[cnt] = i;
            checkBombArea(cnt+1);
        }
    }

    private static int bomb(){

        //여기서 터뜨리고 폭탄 터지는 최대 칸 값 갱신
        int cnt = 0;
        int result = 0;
        boolean[][]selected = new boolean[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    selected[i][j] = true;
                    int bombIdx = numbers[cnt++];

                    int[][] b = bomb[bombIdx];
                    //i,j는 현재 폭탄이 있는곳.
                    //b 배열은 몇번째 폭탄인지 가져온 배열.
                    for(int x = 0; x<4; x++){
                        int nx = i + b[0][x];
                        int ny = j + b[1][x];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if(selected[nx][ny]) continue;
                        selected[nx][ny] = true;
                    }
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){

                if(selected[i][j]) result++;
            }
        }
        return result;
    }
}