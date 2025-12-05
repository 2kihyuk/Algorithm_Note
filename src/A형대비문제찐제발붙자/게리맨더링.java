package A형대비문제찐제발붙자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게리맨더링 {
    private static int N,ans;
    private static int person[];
    private static ArrayList<Integer>[] adjList;

    private static boolean[]isSelected;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        person = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[N+1];
        for(int i = 0; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for(int j = 0; j<c; j++){
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        ans = Integer.MAX_VALUE;
        isSelected = new boolean[N];

        subset(0);


        System.out.println(ans);
    }

    private static void subset(int cnt){

        if(cnt == N){
            ArrayList<Integer> groupA = new ArrayList<>();
            ArrayList<Integer> groupB = new ArrayList<>();
            int sumA = 0 ;
            int sumB = 0;
            for(int i = 0; i<N; i++){
                if(isSelected[i]){
                    groupA.add(i);
                    sumA+=person[i];
                }else{
                    groupB.add(i);
                    sumB+=person[i];
                }
            }

            if(groupA.isEmpty() || groupB.isEmpty()){
                return;
            }

            int groupAP = 0;
            int groupBP = 0;

            if (isConnect(groupA) && isConnect(groupB)) {
                int diff = Math.abs(sumA - sumB);
                ans = Math.min(ans, diff);
            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);


    }
    private static boolean isConnect(ArrayList<Integer> group){
        if(group.size()<=1){
            return true;
        }

        boolean[] visited =new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adjList[cur]){
                if(group.contains(next) && !visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }

        return count == group.size();
    }

}
