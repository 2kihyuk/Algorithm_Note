package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 회문2 {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        for(int tc = 1; tc <= 10; tc++){
            int a = Integer.parseInt(br.readLine());

            char[][] arr= new char[100][100];

            for(int i = 0; i<100; i++){
                String line = br.readLine();
                for(int j =0;j <100;j++){
                    arr[i][j] = line.charAt(j);
                }
            }

            for(int i = 0; i< 100; i++){
                for(int j =0; j<100; j++){


                }
            }

        }
    }
}
