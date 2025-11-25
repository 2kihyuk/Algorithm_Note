package 알고리즘공부정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수묶기_1744 {
    private static int N;

    public static void main(String[] args)throws Exception{

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> underZero = new PriorityQueue<>();
        int oneCnt = 0;
        int zeroCnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 1){
                q.offer(num);
            }else if(num == 0){
                zeroCnt++;
            }else if(num == 1){
                oneCnt++;
            }else if( num < 0){
                underZero.offer(num);
            }
        }

        int ans = 0;

        while(q.size()>=2){
            int a = q.poll();
            int b= q.poll();
            ans+=(a*b);
        }
        //양수가 하나 남은 경우.
        if(!q.isEmpty()) ans+=q.poll();

        while(underZero.size()>=2){
            int a = underZero.poll();
            int b= underZero.poll();
            ans+=(a*b);
        }
        if(!underZero.isEmpty()){
            int lastUnderZero = underZero.poll();
            if(zeroCnt>0){
                zeroCnt--;
            }else{
                ans+=lastUnderZero;
            }
        }

        for(int i = 0; i<oneCnt;i++){
            ans+=1;
        }
        System.out.println(ans);
    }
}
