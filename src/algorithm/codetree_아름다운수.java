package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_아름다운수 {

    private static int[]numbers;
    private static int N;
    private static int ans;


    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        ans = 0;

        go(0);

        System.out.println(ans);
    }
    private static void go(int cnt){
        if(cnt == N){
            if(isBeautiful()){
                ans++;
            }
            return;
        }

        for(int i = 1; i<=4; i++){
            numbers[cnt] = i;
            go(cnt+1);
        }
    }

    private static boolean isBeautiful(){

        int i = 0;
        while(i<N){
            int a = numbers[i];
            int cnt = 1;

            int j = i+1;

            while(j < N && numbers[j] == a){
                cnt++;
                j++;
            }
            if(cnt % a != 0){
                return false;
            }

            i = j;
        }
        return true;
    }

}
