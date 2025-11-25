package Algorihtm_Test_Practice_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_치킨치킨치킨 {

    private static int N;
    private static int M;
    private static int []input;
    private static int []numbers;

    private static int[][] chicken;
    private static int maxSatisfaction = 0;

    public static void main(String[] args)throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        chicken = new int[N][M];
        input = new int[M];

        for(int i = 0; i<M;i++){
            input[i] = i;
        }
        numbers = new int[3];

        for(int i =0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j< M;j++){
                chicken[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0,0);

        System.out.println(maxSatisfaction);
    }

    private  static void combi(int cnt , int start){
        if(cnt == 3){
            //3가지 조합을 골랐을때 , 여기서 또 함수 호출해야함. 그 3가지 가지고 가서, 새로운 2차원 배열 만들어서
            //치킨 만족도의 최댓값 구하기.
            int currentSatisfaction = getMax(numbers);
            if(currentSatisfaction > maxSatisfaction){
                maxSatisfaction = currentSatisfaction;
            }
            return;
        }

        for(int i = start; i<M; i++){
            numbers[cnt] = input[i];
            combi(cnt +1 , i+1);
        }
    }
    private static int getMax(int[] numbers) {
        int totalSatisfaction = 0;

        // 각 학생에 대해 선택된 3개 치킨집 중 최대 만족도를 찾음
        for (int i = 0; i < N; i++) {
            int maxPerStudent = 0;

            // numbers 배열에 있는 3개의 인덱스를 사용
            for (int j = 0; j < 3; j++) {
                int chickenIndex = numbers[j];
                // i번째 학생의 chickenIndex 치킨집에 대한 만족도
                int satisfaction = chicken[i][chickenIndex];

                if (satisfaction > maxPerStudent) {
                    maxPerStudent = satisfaction;
                }
            }
            totalSatisfaction += maxPerStudent;
        }
        return totalSatisfaction;
    }
}
