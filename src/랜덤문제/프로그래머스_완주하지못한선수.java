package 랜덤문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 프로그래머스_완주하지못한선수 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        String ans = solution(participant,completion);
        System.out.println(ans);
    }
    private static String solution(String[] participant, String[] completion){


        HashMap<String,Integer> partic = new HashMap<>();
        for(String p : participant){
            partic.put(p,partic.getOrDefault(p,0) + 1);
        }

        for(String c : completion){
//            if(partic.containsKey(c)){
//                partic.put(c,partic.getOrDefault(c,0)-1);
//            }
            partic.put(c,partic.get(c)-1);
        }
        String ans = "";
        for(Map.Entry<String, Integer> entry : partic.entrySet()){
            if(entry.getValue() > 0){
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
