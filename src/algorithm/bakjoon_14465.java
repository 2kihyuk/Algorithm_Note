package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bakjoon_14465 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[]arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = i;
        }

        int[] broken = new int[B];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<B; i++){
            list.add(Integer.parseInt(br.readLine())-1);
        }
//        0 1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9 10

        //int good = 0;
        int broke = 0;
        for(int i = 0; i<K; i++){
            if(list.contains(i)){
                broke++;
            }
//            else{
//                good++;
//            }
        }
        int min = broke;

        for(int k = 1; k<=N-K;k++){
            int next = arr[k+K-1];
            int remove = arr[k-1];
            if(list.contains(remove)) broke--;
            if(list.contains(next)) broke++;
            min = Math.min(min,broke);

//            if(good == K){
//                //멀쩡한거 개수가 K가 되면 끝
//                break;
//            }
        }
        //고장나서 고친거 개수
        System.out.println(min);
    }
}
