package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


///부분집합으로 지역구를 나눌 수 있는 모든 경우의 수에 대해서 , 나눠진 각 지역구에 대해 각각 bfs를 돌려서 나눠진 지역구의 크기와 탐색한 bfs횟수가 같다면 같은 지역구에 있는것으로 판단하여
//true를 반환하는데, 두 지역구 모두 true라면 이때 지역구간 인구차이를 구해가며 최소 인구차이를 구해나간다.
public class M_17471_게리맨더링 {

    private static int N; //구역의 개수.
    private static int[] person; //구역당 인구수
    private static int ans = Integer.MAX_VALUE;
    private static int dfs_cnt;
    private static boolean[]isSelected;
    private static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        person = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                adjList[i].add(to);
                adjList[to].add(i);
            }
        }

        subset(0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
        private static void subset(int cnt){

            if(cnt == N){
                ArrayList<Integer> groupA = new ArrayList<>();
                ArrayList<Integer> groupB = new ArrayList<>();
                int aSum = 0;
                int bSum = 0;
                for(int i = 0; i<N;i++) {
                    if(isSelected[i]) {
                        groupA.add(i);
                        aSum+=person[i];
                    }else {
                        groupB.add(i);
                        bSum += person[i];
                    }
                }
                if(groupA.isEmpty() || groupB.isEmpty()){
                    return;
                }

                if(isConnect(groupA) && isConnect(groupB)){
                    int diff = Math.abs(aSum - bSum);
                    ans = Math.min(ans,diff);
                    return;
                }
                return;
            }

            isSelected[cnt] = true;
            subset(cnt +1);
            isSelected[cnt] = false;
            subset(cnt + 1);
        }

        private static boolean isConnect(ArrayList<Integer> group){

            //bfs로.
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[N];
            int count = 1;

            q.offer(group.get(0));
            visited[group.get(0)] = true;

            while(!q.isEmpty()){
                int current = q.poll();

                for(int next : adjList[current]){
                    if(group.contains(next) && !visited[next]){
                        q.offer(next);
                        visited[next] = true;
                        count++;
                    }
                }
            }


            return group.size() == count;

        }

    }



//private static void subset(int cnt){
//
//    if( cnt == N){
//        //여기서 부분집합 나왔으니가 이거 가지고 dfs돌리고 둘다 pass하면 계산.
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        int sum1 = 0;
//        int sum2 = 0;
//
//        for(int i = 0; i < N ; i++){
//            if(isSelected[i]){
//                list1.add(i);
//                sum1+=person[i];
//            }else{
//                list2.add(i);
//                sum2+=person[i];
//            }
//        }
//        if (list1.isEmpty() || list2.isEmpty()) {
//            return;
//        }
//        if(dfs(list1) && dfs(list2)){
//            int diff = Math.abs(sum1-sum2);
//            ans = Math.min(ans,diff);
//        }
//        return;
//    }
//
//    isSelected[cnt] = true;
//    subset(cnt + 1);
//
//    isSelected[cnt] = false;
//    subset(cnt + 1);
//}
//
//private static boolean dfs(ArrayList<Integer> list){
//
//    if(list.size() <=1){
//        return true;
//    }
//
//    boolean[] visited = new boolean[N];
//    ArrayDeque<Integer> q = new ArrayDeque<>();
//
//    int count = 1; //현재 노드는 탐색완료
//    q.offer(list.get(0));
//    visited[list.get(0)] = true;
//
//    while(!q.isEmpty()){
//        int current = q.poll();
//
//        for(int next : adjList[current]){
//            if(!visited[next]  && list.contains(next)){
//                q.offer(next);
//                visited[next] = true;
//                count++;
//            }
//        }
//    }
//    ///부분집합이 담긴 리스트를 받아왔으니, bfs로 탐색후, count가 list.size()와 같다면 성공 , 아니면 false.
//
//
//    return count == list.size();
//}