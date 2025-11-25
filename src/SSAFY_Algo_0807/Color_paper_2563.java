package SSAFY_Algo_0807;

import test.Parent;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Color_paper_2563 {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int arr[][] = new int[100][100];


        for(int i =0; i<N;i++){
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            for(int x = a; x<a+10; x++){
                for(int y = b; y<b+10; y++){
                    if(arr[x][y] == 0){
                        arr[x][y] = 1;
                        count++;

                    }
                }
            }
        }


        System.out.println(count);



    }
}
