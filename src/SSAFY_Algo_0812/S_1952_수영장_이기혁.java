package SSAFY_Algo_0812;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class S_1952_수영장_이기혁
{
    private static int resultPrice;
    private static int dayPrice;
    private static int monthPrice;
    private static int Three_monthPrice;
    private static int yearPrice;
    private static int[] arr;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {

            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            dayPrice = Integer.parseInt(st.nextToken());
            monthPrice = Integer.parseInt(st.nextToken());
            Three_monthPrice = Integer.parseInt(st.nextToken());
            yearPrice = Integer.parseInt(st.nextToken());

            arr = new int[13];

            st = new StringTokenizer(br.readLine().trim());

            for(int i =0; i<arr.length-1;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            resultPrice = yearPrice;
            dfs(0,0);
            System.out.println("#" + test_case + " " + resultPrice);
        }
    }

    private static void dfs(int month , int price) {

        if(month > 12) {
            resultPrice = Math.min(resultPrice, price);
            return;
        }

        if(price >= resultPrice) {
            return;
        }

        int d = arr[month];

        dfs(month + 1, price + d * dayPrice); //하루 이용하는가격.
        dfs(month + 1, price + monthPrice); //한달이용권으로 이용하는 가격.
        dfs(month + 3, price + Three_monthPrice);

    }
}
