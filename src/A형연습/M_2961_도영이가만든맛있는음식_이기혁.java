//package A형연습;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class M_2961_도영이가만든맛있는음식_이기혁 {
//
//    private static int N;
//    private static boolean isSelected[];
//    private static int S[];
//    private static int B[];
//    private static int ans;
//
//    //부분 집합 문제.
//    public static void main(String[] args)throws  Exception {
//
//        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        S = new int[N];
//        B = new int[N];
//        isSelected = new boolean[N];
//        StringTokenizer st;
//        for(int i = 0; i<N; i++){
//            st = new StringTokenizer(br.readLine());
//            S[i] = Integer.parseInt(st.nextToken());
//            B[i] = Integer.parseInt(st.nextToken());
//        }
//        ans = Integer.MAX_VALUE;
//        subset(0,1,0);
//        System.out.println(ans);
//    }
//    private static void subset(int cnt, int s , int b){
//        if(cnt == N){
//            for(int i = 0; i< N; i++){
//                if(isSelected[i]){
//                    int diff = Math.abs(s-b);
//                    ans = Math.min(ans,diff);
//                }
//            }
//            return;
//        }
//        int sour = S[cnt];
//        int bit = B[cnt];
//
//        isSelected[cnt] = true;
//        subset(cnt + 1, s * sour , b+bit);
//
//        isSelected[cnt] = false;
//        subset(cnt + 1 , s , b );
//    }
//}
