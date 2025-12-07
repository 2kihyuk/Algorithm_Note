package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 너의평점은_25206 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalSum  = 0.0;
        double totalScore = 0.0;

        for(int i = 0; i<20; i++){
            st = new StringTokenizer(br.readLine());
            String major = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P")) continue;
            totalSum+=score;

            if(grade.equals("A+")){
                totalScore+=(score*4.5);
            }else if(grade.equals("A0")){
                totalScore+=(score*4.0);
            }else if(grade.equals("B+")){
                totalScore+=(score*3.5);
            }else if(grade.equals("B0")){
                totalScore+=(score*3.0);
            }else if(grade.equals("C+")){
                totalScore+=(score*2.5);
            }else if(grade.equals("C0")){
                totalScore+=(score*2.0);
            }else if(grade.equals("D+")){
                totalScore+=(score*1.5);
            }else if(grade.equals("D0")){
                totalScore+=(score*1.0);
            }else if(grade.equals("F")){
                totalScore+=0.0;
            }

        }

        double ans = (totalScore/totalSum);

        System.out.printf("%.6f",ans);

    }
}
