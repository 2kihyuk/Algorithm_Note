package 알고리즘공부구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {

    private static int[][] arr;
    private static int k;

    public static void main(String[] args)throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        // 회전 횟수 입력
         k = Integer.parseInt(br.readLine());

        for(int t = 0; t<k; t++){
            st = new StringTokenizer(br.readLine());
            int wheel = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[5];
            dirs[wheel] = dir; //시작하는 바퀴의 회전 방향이 무엇인지

            //왼쪽 연쇄 전파
            for(int i = wheel -1; i>=1;i--){
                if(arr[i][2] != arr[i+1][6]){
                    dirs[i] = -dirs[i+1];
                }else{
                    break;
                }
            }
            //오른쪽 연쇄 전파
            for(int i = wheel+1; i<=4;i++){
                if (arr[i - 1][2] != arr[i][6]) {
                    dirs[i] = -dirs[i - 1];
                } else {
                    break; // 같으면 더 이상 오른쪽으로 전파 X
                }
            }

            for(int i = 1; i<=4; i++){
                if(dirs[i] != 0 ) rotate(i,dirs[i]);
            }
        }
        int ans = 0;


        if(arr[1][0] == 1)ans+=1;
        if(arr[2][0] == 1)ans+=2;
        if(arr[3][0] == 1)ans+=4;
        if(arr[4][0] == 1)ans+=8;

        System.out.println(ans);

    }

    private static void rotate(int wheel,int dir){
        if(dir == -1){
            int temp = arr[wheel][0];
            for(int j =1; j<8;j++){
                arr[wheel][j-1] = arr[wheel][j];
            }
            arr[wheel][7] = temp;
        }else{
            //시계 방향으로 돌리기
            int temp = arr[wheel][7];
            for(int j = arr[wheel].length-2; j>=0;j--){
                arr[wheel][j+1] = arr[wheel][j];
            }
            arr[wheel][0] = temp;
        }
    }
}
