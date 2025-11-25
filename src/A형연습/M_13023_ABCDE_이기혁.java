package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M_13023_ABCDE_이기혁 {

    private static ArrayList<Integer> [] adjList;
    private static int N;
    private static int M;

    private static boolean ans;
    private static int cnt;

    private static boolean[]visited;
    public static void main(String[] args)throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        adjList = new ArrayList[N];
        for(int i = 0; i<N;i++){
            adjList[i] =new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for(int i =0 ; i<N;i++){
            if(ans){
                break;
            }
            dfs(i,1);
        }

        System.out.println(ans ? "1" : "0");
    }

    private static void dfs(int start, int cnt){

        if(cnt == 5){
            ans = true;
            return;
        }
        visited[start] = true;

        for(int next : adjList[start]){
            if(!visited[next]){
                dfs(next, cnt + 1);
                if(ans){
                    return;
                }
            }
        }
        visited[start] = false;


    }
}
