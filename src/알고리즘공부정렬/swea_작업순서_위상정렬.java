package 알고리즘공부정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_작업순서_위상정렬 {


    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;

        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int[] inDegree = new int[V+1];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i = 0;i<=V;i++) list.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<E; i++){
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());

                list.get(from).add(to);
                inDegree[to]++;
            }

            ArrayDeque<Integer> q = new ArrayDeque<>();
            for(int i = 1; i<=V;i++){
                if(inDegree[i] == 0) q.offer(i);
            }

            sb.append('#').append(tc).append(' ');
            while(!q.isEmpty()){
                int cur = q.poll();
                sb.append(cur).append(' ');

                for(int next : list.get(cur)){
                    inDegree[next]--;
                    if(inDegree[next] == 0) q.offer(next);
                }
            }

            System.out.println(sb);
        }
    }
}
