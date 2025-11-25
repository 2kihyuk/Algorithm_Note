package algorithm;


import java.util.Scanner;

public class codetree_테트리스블럭안합최대화하기2 {
    private static int[][]arr;
    private static boolean[][]visited;
    private static int N,M,ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ans = 0;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                visited[i][j] = true;
                check(i,j,1,arr[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.print(ans);
    }
    private static void check(int x, int y, int cnt, int sum){

        if(cnt == 5){
            ans = Math.max(ans,sum);
            return;
        }

        int curX = x;
        int curY = y;

        if(curX + 1 < N && !visited[curX+1][curY]){
            visited[curX+1][curY] = true;
            check(curX+1,curY,cnt+1,sum+arr[curX+1][curY]);
            visited[curX+1][curY] = false;
        }
        if(curX -1 >= 0 && !visited[curX-1][curY]){
            visited[curX-1][curY] = true;
            check(curX-1,curY,cnt+1,sum+arr[curX-1][curY]);
            visited[curX-1][curY] = false;
        }
        if(curY + 1 < M && !visited[curX][curY+1]){
            visited[curX][curY+1] = true;
            check(curX,curY+1,cnt+1,sum+arr[curX][curY+1]);
            visited[curX][curY+1] = false;
        }
        if(curY - 1 >= 0 && !visited[curX][curY-1]){
            visited[curX][curY-1] = true;
            check(curX,curY-1,cnt+1,sum+arr[curX][curY-1]);
            visited[curX][curY-1] = false;
        }
    }
}