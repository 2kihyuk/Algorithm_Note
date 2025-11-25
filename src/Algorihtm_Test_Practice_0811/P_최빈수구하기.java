package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_최빈수구하기 {

    //1000명의 수학점수를 받을건데, 가장 많이 나온 점수가 최빈수이다.
    //최빈수를 출력하라.

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            int tc = Integer.parseInt(br.readLine());

            int scores[] =new int[101]; //점수는 0이상 100이하의 점수. 총 101개의 인덱스를 가진 점수 배열.
            StringTokenizer st = new StringTokenizer(br.readLine());

            //학생 1000명의 점수를 받아서, 점수배열의 점수인덱스를 증가시킴. 80점이라면 80번 인덱스++;
            for(int i =0; i<1000; i++){
                int score =  Integer.parseInt(st.nextToken());
                scores[score]++;
            }
            int maxScore = Integer.MIN_VALUE;
            int maxCount = Integer.MIN_VALUE;

            for(int i =0; i<scores.length;i++){
                if(scores[i] > maxCount){
                    maxCount = scores[i];
                    maxScore = i;
                }else if(scores[i] == maxCount){
                    maxScore = Math.max(maxScore, i);
                }
            }

            System.out.println("#" + test_case + " " + maxScore);

        }
    }
}


