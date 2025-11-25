package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bakjoon_1764 {
    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;

        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            set.add(str);
        }

        for(int i = 0; i<M; i++){
            String str = br.readLine();
            if(!set.add(str)){
                ans++;
                list.add(str);
            }
        }
        Collections.sort(list);
        for(String s : list){
            sb.append(s).append('\n');
        }
        System.out.println(ans);
        System.out.println(sb.toString());
    }
}
