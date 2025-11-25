package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class codetree_1차원폭발게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[100];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        while(true){
            boolean removed = false;
            ArrayList<Integer> next = new ArrayList<>();

            int i = 0;
            while(i < list.size()){
                int j = i+1;
                while(j<list.size() && list.get(i) == list.get(j)){
                    j++;
                }
                int len = j-i;

                if(len >= M){
                    removed = true;
                }else{
                    for(int k = i; k<j;k++){
                        next.add(list.get(k));
                    }
                }

                i = j;
            }
            if(!removed)break;
            list = next;
        }

        StringBuilder sb = new StringBuilder();
        for (int x : list) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
