package 알고리즘공부구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 드래곤커브_15685 {

    private static int N; //드래곤 커브의 개수
    private static boolean[][] arr = new boolean[101][101];
    private static int[]dx = {1, 0, -1, 0}; // 우 상 좌 하 순서
    private static int[]dy = {0, -1, 0, 1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            // int time = (int) Math.pow(2,generation); //time횟수만큼 그리기. 2의 genenration 제곱번이긴함.
            // 저 횟수만큼 그리는게 아니라 몇세대의 드래곤인지, 세대수만큼 반복을 돌릴 건데, 그 안에서 2세대라면 0,1 , 즉 2번 반복문 돌릴건데, dirs에는 초기에 1번 즉 0세대거 들어가있으니까
            // 첫 반복문에서는 1세대를, 두번째 반복문에서는 리스트에 2개들어가있으니까, 그 횟수만큼, 즉 총 4개의 방향이 들어감.
            // 0세대 - > 1번 1세대 -> 0세대 * 2 2세대 -> 1세대 * 2
            ArrayList<Integer> dirs = new ArrayList<>();
            dirs.add(dir);

            for(int gen = 0; gen<generation;gen++){
                for(int k = dirs.size() -1; k >= 0; k--){
                    dirs.add( (dirs.get(k) + 1) % 4 );
                }
            }

            arr[x][y] = true;
            for(int direction: dirs){
                x+=dx[direction];
                y+=dy[direction];
                if (x < 0 || y < 0 || x > 100 || y > 100) continue;
                arr[x][y] = true;
            }
        }

        int answer = 0;
        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j<100; j++){
                if(arr[i][j]  && arr[i+1][j]&& arr[i][j+1]  && arr[i+1][j+1]  ){
                    answer++;
                }
            }
        }

        System.out.println(answer);


    }
}
