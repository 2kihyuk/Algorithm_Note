package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_수영장_이기혁 {
    private static int result;

    private static int day;
    private static int month;
    private static int three_month;
    private static int year;

    private static int[] arr;

    public static void main(String[] args)throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            three_month = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            arr = new int[12];
            st= new StringTokenizer(br.readLine());
            for(int i = 0; i<12;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = year;

            checkPrice(0, 0);

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void checkPrice(int cnt , int price){

        if(cnt >= 12){
            result = Math.min(result, price);
            return;
        }


        int swimday = arr[cnt];
        checkPrice(cnt + 1, price + swimday * day);
        checkPrice(cnt + 1 , price + month);
        checkPrice(cnt + 3, price + three_month);
    }
}
