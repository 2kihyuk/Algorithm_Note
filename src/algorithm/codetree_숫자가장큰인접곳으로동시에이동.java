//package algorithm;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.sql.Array;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class codetree_숫자가장큰인접곳으로동시에이동 {
//    private static int N,M,K;
//    private static int[][]arr;
//    private static int[]dx = {-1,1,0,0};
//    private static int[]dy = {0,0,-1,1};
//
//    private static int ans;
//    private static class Node{
//        int value;
//        int x, y;
//        public Node(int value,int x, int y){
//            this.value =value;
//            this.x =x;
//            this.y =y;
//        }
//    }
//
//    public static void main(String[] args)throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        ans = 0;
//
//        arr = new int[N][N];
//
//        for(int i = 0; i<N; i++){
//            st= new StringTokenizer(br.readLine());
//            for(int j = 0; j<N; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        ArrayList<int[]> list = new ArrayList<>();
//
//
//        for(int i = 0; i<M; i++){
//            st = new StringTokenizer(br.readLine());
//            int r = Integer.parseInt(st.nextToken())-1;
//            int c =Integer.parseInt(st.nextToken())-1;
//            list.add(new int[]{r,c});
//        }
//        ArrayDeque<int[]> q = new ArrayDeque<>();
//        boolean[][] visited = new boolean[N][N];
//
//        for(int [] num : list){
//            int startX = num[0];
//            int startY = num[1];
//
//            q.offer(new int[]{startX,startY});
//            visited[startX][startY]  = true;
//        }
//
//
//        while(K-->0){
//            int size = q.size();
//            for(int i = 0; i<size; i++){
//                int[]cur = q.poll();
//                int curX = cur[0];
//                int curY = cur[1];
//                PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
//                    return Integer.compare(o2.value,o1.value);
//                });
//                for(int d = 0; d<4; d++){
//                    int nx = curX + dx[d];
//                    int ny = curY + dy[d];
//
//                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
//                    if(arr[nx][ny] > arr[curX][curY]) {
//                        pq.offer(new Node(arr[nx][ny],nx,ny));
//                    }
//                    //이제 우선순위 따져야함.
//
//                }
//                if(pq.isEmpty()){
//                    //비어있다? 갈수 없음. break;
//                    continue;
//                }else{
//                    Node next = pq.poll();
//                    if(visited[next.x][next.y]){
//                        //겹치는 공간이니까 터뜨리기
//                        ans+=2;
////                    visited[next.x][next.y] = false;
////                    visited[curX][curY] = false;
//                        arr[curX][curY] = 0;
//                        arr[next.x][next.y] = 0;
//                        break;
//                    }
//                    int nextX = next.x;
//                    int nextY = next.y;
//                    visited[nextX][nextY] = true;
//                    q.offer(new int[]{nextX,nextY});
//                }
//
//            }
//        }
//
//
//        System.out.println(ans);
//
//
//    }
//}
//
//


package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class codetree_숫자가장큰인접곳으로동시에이동 {
    private static int N,M,K;
    private static int[][]arr;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i = 0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구슬들 시작 좌표
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            q.offer(new int[]{r, c});
        }


        for(int step = 0 ; step<K; step++){
            if (q.isEmpty()) break;  // 더 이상 구슬 없으면 끝
            int[][] cnt = new int[N][N];      // 이번 턴에 각 칸으로 몇 개가 모이는지

            int size = q.size();

            for(int  i = 0; i<size; i++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                int bestX = x;
                int bestY = y;
                int bestVal = -1;

                for(int d = 0; d<4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if (arr[nx][ny] > bestVal) {
                        bestVal = arr[nx][ny];
                        bestX = nx;
                        bestY = ny;
                    }
                }
                cnt[bestX][bestY]++;
            }
            q.clear();
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(cnt[i][j] == 1){
                        q.offer(new int[]{i,j});
                    }
                }
            }
        }

        System.out.println(q.size());


    }
}
