package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    private static int N;
    private static ArrayList<int[]> list;
    public static void main(String[] args)throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start,end});
        }

        Collections.sort(list,(o1, o2) ->{
            if(o1[1] == o2[1]){
                return Integer.compare(o1[0],o2[0]);
            }
            return Integer.compare(o1[1],o2[1]);
        });

//        int len = list.size();

        int ans = 0;
        int lastEnd = 0;

        for(int h[] : list){
            int start = h[0]; int end = h[1];

            if(start >= lastEnd){
                ans++;
                lastEnd = end;
            }
        }

        System.out.println(ans);

//        for(int i = 0; i<len;i++){
//
//            int pick[] = list.get(i);
//            int start = pick[0]; int end = pick[1];
//            int tempCnt = 1;
//
//            for(int j = i+1; j<len;j++){
//                int next[] = list.get(j);
//                int nextStart = next[0]; int nextEnd = next[1];
//                if(start == nextStart) continue;
//                if(end > nextEnd) continue;
//                if(end == nextStart){
//                    tempCnt++;
//                    start = nextStart;
//                    end = nextEnd;
//                }else if(end < nextStart){
//                    tempCnt++;
//                    start = nextStart;
//                    end = nextEnd;
//                }
//
//            }
//            ans = Math.max(ans,tempCnt);
//        }
//        System.out.println(ans);
    }
}
