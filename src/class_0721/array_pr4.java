package class_0721;

import java.util.Scanner;

public class array_pr4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[4][4];
        boolean[][] used = new boolean[4][4];

        int sum = 0;

        for(int i =0; i<4;i++){
            for(int j =0; j<4;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }

        for(int i =0; i<4; i++){
            for(int j =0; j<4; j++){

                if (grid[i][j] == 'X') {
                    if(j-1 >=0 &&  grid[i][j-1] !='X' && !used[i][j-1]){
                        used[i][j-1] = true;
                        sum+=grid[i][j-1] - '0';
                    }
                    if(j+1 <4 && grid[i][j+1] !='X' && !used[i][j+1]){
                        used[i][j+1] = true;
                        sum+=grid[i][j+1] - '0';
                    }
                    if(i-1 >=0 && grid[i-1][j] !='X' && !used[i-1][j]){
                        used[i-1][j] = true;
                        sum+=grid[i-1][j] - '0';
                    }
                    if(i+1 < 4 && grid[i+1][j] != 'X' && !used[i+1][j]){
                        used[i+1][j] = true;
                        sum+=grid[i+1][j] - '0';
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
