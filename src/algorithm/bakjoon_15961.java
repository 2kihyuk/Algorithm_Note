package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bakjoon_15961 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[]arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[]exp = new int[N+k-1];
        for(int i = 0; i<N; i++){
            exp[i] = arr[i];
        }
        for(int i =0; i<k-1;i++){
            exp[i+N] = arr[i];
        }

        int[]count = new int[d+1];
        int species = 0;

        for(int i = 0; i<k; i++){
            int fish = exp[i];
            if(count[fish] == 0) species++;
            count[fish]++;
        }

        int ans;
        int cur = species;
        if(count[c] == 0) cur++;
        ans = cur;

        for(int i = 1; i<N; i++){
            int remove = exp[i-1];
            int add = exp[i+k-1];

            count[remove]--;
            if(count[remove] == 0) species--;


            if(count[add] == 0) species++;
            count[add]++;

             cur = species;
            if(count[c] == 0) cur++;

            if(ans < cur) ans = cur;

        }
        System.out.println(ans);
    }
}


//공짜로 주는 초밥을 제외한 서로 다른 k개 만큼의 수열을 고르면 된다. 최대한
