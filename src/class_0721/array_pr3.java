package class_0721;

import java.util.Scanner;

public class array_pr3 {

    public static void main(String[] args) {
        //2차원 배열 좌우 탐색.

        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[4][4];

        int sum = 0;

        for(int i =0; i<4;i++){
            for(int j =0; j<4;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }

        for(int i =0; i<4;i++){
            for(int j =0; j<4;j++){
                if(grid[i][j] == 'X'){
                    if(j-1 >=0 && grid[i][j-1] != 'X') sum+=grid[i][j-1] - '0';
                    if(j+1 <4 && grid[i][j+1] != 'X') sum+=grid[i][j+1] -'0';
                }
            }
        }
        System.out.println(sum);
    }
}
