package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수_2908 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String f = st.nextToken();
        String s = st.nextToken();

//        StringBuilder s1 = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
            String s1 = "";
            String s2 ="";
        for(int i = f.length()-1; i>=0;i--){
            s1+=f.charAt(i);
            s2+=s.charAt(i);
        }
//        String x = s1.toString();
//        String y = s2.toString();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);

        System.out.println(Math.max(a,b));


    }
}
