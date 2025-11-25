package 알고리즘공부BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 빙산_2573 {
    private static int N,M;
    private static int arr[][];
    private static int ans;
    private static int[]dx = {-1,1,0,0};
    private static int[]dy = {0,0,-1,1};
    private static ArrayList<int[]> ice;

    public static void main(String[] args)throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new ArrayList<>();

        arr = new int[N][M];
        for(int i = 0 ; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > 0) ice.add(new int[]{i,j});
            }
        }

        while(true){
            if(ice.isEmpty()){
                System.out.println(0);
                return;
            }

            if(isSplitisMoreThanTwo()){
                System.out.println(ans);
                return;
            }

            melt();
            ans++;
        }

        //처음 한 생각

        //일단 한번 전체를 도는데(1년), 각 칸에 대해서 1년이 지나면 몇만큼 녹는지 카운트하고, 그 값만큼 딱빼고, 두 덩이 이상으로 분리가 되었는지 체크 하는 작업을 반복 하다가 두덩이 이상이면 끝.
        //빙산이 다 녹을때까지 분리가 되지 않는다면 -1.
        //그럼 끝까지 돌려야하는데, 각 칸에 들어갈 수 있는 값은 최대 10이니까, for문을 10번돌리는데, 빙산이 있는 칸이 존재할 수 있는 갯수는 최대 10000개니까 한번돌릴떄, 최대 10000번 .
        // 총 10만번이니까 1초안에 이 로직으로 가능한가?

        //해마다 스캔한다 라는 생각은 맞는데, for문으로 10번 돌린느건 잘못됨.

        //---> while()문에서 끝날때까지 돌릴건데, 빙산을 담는 ArrayList를 하나 만들어서 , 이거 가지고 녹여보고, 두덩이 이상이면 끝이고, 계속 돌리다가 빙산을 담고있는
        //ArrayList가 비었는데도 두덩이로 분리가 안된거면 0.


    }
    private static void melt(){
        int[] melt = new int[ice.size()];
        for(int i = 0; i<ice.size();i++){
            int x = ice.get(i)[0];
            int y = ice.get(i)[1];
            int cnt = 0;
            for(int j =0; j<4; j++){
                int nx = x + dx[j];
                int ny = y+dy[j];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(arr[nx][ny] == 0)cnt++;
            }
            melt[i] = cnt;
        }
        ArrayList<int[]> newIce = new ArrayList<>();
        for(int i = 0; i<ice.size();i++){
            int x = ice.get(i)[0];
            int y = ice.get(i)[1];
            arr[x][y] = Math.max(0,arr[x][y]- melt[i]);
            if(arr[x][y] > 0) newIce.add(new int[]{x,y});
        }
        ice = newIce;
    }
    private static boolean isSplitisMoreThanTwo(){
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> q= new ArrayDeque<>();

        int[]start = ice.get(0);
        q.add(start);
        visited[start[0]][start[1]] = true;
        int visitedCnt = 0;

        while(!q.isEmpty()){
            int[]cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            visitedCnt++;

            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx<0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] <= 0) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});

            }
        }
        return ice.size() > visitedCnt;
        //ice에 5개의 빙산이 들어있다고 가정해보자.
        //만약 bfs돌렸는데, visitedCnt
    }

}
