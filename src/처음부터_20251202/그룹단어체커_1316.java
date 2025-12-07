package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 그룹단어체커_1316 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0; i<N; i++){
            String line = br.readLine();

            //line에 대해서 판별.
            //그룹단어면 ans++
            if(group(line)){
                ans++;
            }
        }
        System.out.println(ans);
    }
    private static boolean group(String line){
        if(line.length()==1) return true;

        int[] arr = new int[26];
        boolean isGroup = true;

        char first = line.charAt(0);
        int firstIdx = first - 'a';

        arr[firstIdx]++;

        for(int i = 1; i<line.length(); i++){
            char c = line.charAt(i);
            int cIdx = c-'a';
            if(arr[cIdx] != 0){
                char prev = line.charAt(i-1);
                if(c!=prev){
                    isGroup = false;
                    break;
                }else{
                    //이전 문자랑 같다. 연속된다.
                    arr[cIdx]++;
                }
            }else{
                //새로운 문자다.
                arr[cIdx]++;
            }
        }

        return isGroup;
    }
}


/*
happy year 은 그룹단어 확인. 한글자 한글자씩 확인?
ab도 그룹단어. 그러나 aba는 그룹단어 아님. 왜? ab까지는 괜찮은데 a가 또 나와서 떨어져있으면 안됨. 연속되어야한다.
 */

//그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
//
//단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
//
//        출력
//첫째 줄에 그룹 단어의 개수를 출력한다.
//
//예제 입력 1
//        3
//happy
//new
//year
//예제 출력 1
//        3
//예제 입력 2
//        4
//aba
//        abab
//abcabc
//        a
//예제 출력 2
//        1