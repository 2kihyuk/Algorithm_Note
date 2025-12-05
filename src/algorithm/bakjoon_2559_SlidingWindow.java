package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjoon_2559_SlidingWindow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[]arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;

        for(int i = 0; i<M; i++){
            sum+=arr[i];
        }
        //첫번째 윈도우.

        int ans = sum;

        //두번째 윈도우부터 시작해서 밀고나가기.
        //새로 더할 값 더하고, 이전 윈도우의 첫번째 값 빼기.
        for(int i = M; i<N;i++){
            sum+=arr[i];
            sum-=arr[i-M];
            ans = Math.max(ans,sum);
        }

        System.out.println(ans);
    }
}


//	1.	20922 겹치는 건 싫어
//	2.	15961 회전 초밥
//	3.	14465 소가 길을 건너간 이유 5
//        4.	22862 가장 긴 짝수 연속 부분 수열
//	5.	1644 소수의 연속합
//	6.	(여유되면) 12891 DNA 비밀번호, 13422 도둑
//	7.	(심화) 2461 대표 선수


//토마토, 게리멘더링, 슬라이딩윈도우, 나무높이, 순열, 조합,