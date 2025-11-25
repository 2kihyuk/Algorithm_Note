package SSAFY_Algo_0812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M_17471_게리맨더링 {
    //여기서부터는 부분집합을 위한 변수들.
    private static int N; //총 도시의 개수.
//    private static int[] input;
//
//    private static int[]numbers;
//    private static int[]ohternumbers;

    private static boolean[] isSelected;

    private static StringTokenizer st;
    private static int[] person; //각 도시의 차례대로 인구수 저장하기 위한 배열.

    private static int minDiff = Integer.MAX_VALUE;

    ///여기까지.

    ///여기서부터는 dfs를 위한 변수들
    private static ArrayList<Integer>[]adjList;

//    private static int result = Integer.MAX_VALUE; //최종 결과
//    private static int numbersResult; //뽑은 구역의 인구 값.
//    private static int othernumberResult; //뽑지 않은 나머지 구역의 인구 값.
    //private static boolean[]visited;

    ///여기까지
    public static void main(String[] args) throws Exception{
        // 구역을 둘로 나누고, 각 나눠진 구역에 대해 dfs를 돌려서 각 구역이 잘 연결되어있는지를 확인하고, 잘 되어있다면 이 경우들의 구역간 인구 차이의 최소값을 구해라..

        //그럼 구역을 둘로 어떻게 나눌거냐? 1 / 23456 .. ~ 12345 /6 의 경우까지 모두 따져야한다고?

        //부분집합으로 하나뽑으면 그 뽑은곳에서 새로운 배열? 만들어서 해당 배열 가지고 dfs/ bfs 돌리고 , 나머지 값들로도 배열로 나누어 dfs돌려서 해당 구역도 타당한지 확인하기?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        isSelected = new boolean[N];
        person = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++){ // i < N으로 수정
            person[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[N];
        for(int i = 0; i < N; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine().trim());
            int neighborCount = Integer.parseInt(st.nextToken());

            for(int j = 0; j < neighborCount; j++){
                int neighbor = Integer.parseInt(st.nextToken()) - 1; // 0-based index로 변경
                adjList[i].add(neighbor);
                adjList[neighbor].add(i);
            }
        }

        generateSubset(0);

        if (minDiff == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDiff);
        }

    }

    private static void generateSubset(int cnt){

        if(cnt == N){
            ArrayList<Integer> groupA = new ArrayList<>();
            ArrayList<Integer> groupB = new ArrayList<>();
            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    groupA.add(i);
                    sumA += person[i];
                } else {
                    groupB.add(i);
                    sumB += person[i];
                }
            }

            // 두 그룹이 모두 비어있거나, 한쪽 그룹만 비어있으면 유효하지 않음
            if (groupA.isEmpty() || groupB.isEmpty()) {
                return;
            }
            // 두 그룹이 각각 연결되어 있는지 확인
            if (isConnect(groupA) && isConnect(groupB)) {
                int diff = Math.abs(sumA - sumB);
                minDiff = Math.min(minDiff, diff);
            }
            return;
        }

        //유도 부분
        //첫번째 원소 선택 - 현재 원소를 부분집합에 포함.
        isSelected[cnt] = true;
        generateSubset(cnt+1);

        //현재 원소를 부분집합에 미포함
        isSelected[cnt] = false;
        generateSubset(cnt+1);

    }

    private static boolean isConnect(ArrayList<Integer> group){
        if(group.size()<=1){
            return true;
        }

        boolean[] visited =new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(group.get(0));
        visited[group.get(0)] = true;

        int count = 1; //탐색한 개수.
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
        // 탐색한 노드 개수가 그룹의 전체 크기와 같으면 연결된 것임
        return count == group.size();
    }


}


