package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_길찾기 {

    private static ArrayList<Integer>[] adjList;
    private static boolean[]visited;
    private static boolean result;
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){

            String str [] = br.readLine().split(" ");
            int tc = Integer.parseInt(str[0]);
            int len = Integer.parseInt(str[1]);

            adjList = new ArrayList[100];
            for(int i =0; i<100;i++){
                adjList[i] = new ArrayList<>();
            }

            visited = new boolean[100];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i<len;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
            }

            result = false;
            dfs(0);

            System.out.println("#" + test_case + " " + (result ? "1" : "0"));

        }
    }
    private static void dfs(int now){

        if(now == 99){
            result = true;
            return;
        }

        visited[now] = true;

        for(int next : adjList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}



