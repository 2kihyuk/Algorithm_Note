package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Color_paper {


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[100][100];
        int count = 0;

        for(int i = 0 ; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //10X10크기의 사각형이 시작되는 왼쪽 하단 좌표를 a,b로 받아서, a로부터 10, b로부터 10까지의 공간이 만약 0이라면 1로 바꾸고, count를 증가시킨다.
            //겹치는 부분은 이미 1이 되어있기 때문에 세지않고, 0인 부분만 1로 바꾸어 count를 증가시킨다면 겹치는 부분은 세지않고 겹치지 않는 부분만 셀 수 있다.
            for(int x = a; x< a+ 10; x++){
                for(int y = b; y < b+ 10; y++){
                    if(arr[x][y] == 0 ){
                        arr[x][y] = 1;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);


    }
}
