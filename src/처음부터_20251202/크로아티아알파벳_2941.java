package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 크로아티아알파벳_2941 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int len = line.length();
        int cnt = 0;
        int idx = 0;

        while(idx < len){

            if(idx+2 < len && line.charAt(idx) == 'd' && line.charAt(idx+1) == 'z' && line.charAt(idx+2) == '='){
                cnt++;
                idx+=3;
                continue;
            }else if(idx +1 < len){
                String two = line.substring(idx,idx+2);
                if (two.equals("c=") || two.equals("c-") ||
                        two.equals("d-") || two.equals("lj") ||
                        two.equals("nj") || two.equals("s=") ||
                        two.equals("z=")){
                    cnt++;
                    idx+=2;
                    continue;
                }else{
                    cnt++;
                    idx++;
                    continue;
                }
            }
            else{
                cnt++;
                idx++;
            }
        }

        System.out.println(cnt);

    }
}
