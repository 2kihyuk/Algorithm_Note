package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjoon_22862 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[N+1];
        //1부터 시작
        st= new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //1 2 3 4 5 6 7 8    M=2
//수열
//S에서 최대
//최대 K번 원소를 삭제한 수열에서 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 출력한다.
        int left = 0;

        int oddCnt = 0;
        int ans = 0;
        for(int right = 0; right<N; right++){
            if(arr[right] % 2 != 0) oddCnt++;

            while(oddCnt > M){
                if(arr[left] %2 !=0){
                    oddCnt--;
                }
                left++;
            }
            int len = right - left + 1;
            int evenCnt = len - oddCnt;
            ans = Math.max(ans,evenCnt);
        }
        System.out.println(ans);
    }
}
