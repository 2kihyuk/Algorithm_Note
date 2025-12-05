package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다이얼_5622 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int time = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('A' <= c && c <= 'C') {
                time += 3;      // 2번
            } else if ('D' <= c && c <= 'F') {
                time += 4;      // 3번
            } else if ('G' <= c && c <= 'I') {
                time += 5;      // 4번
            } else if ('J' <= c && c <= 'L') {
                time += 6;      // 5번
            } else if ('M' <= c && c <= 'O') {
                time += 7;      // 6번
            } else if ('P' <= c && c <= 'S') {
                time += 8;      // 7번
            } else if ('T' <= c && c <= 'V') {
                time += 9;      // 8번
            } else if ('W' <= c && c <= 'Z') {
                time += 10;     // 9번
            }
        }

        System.out.println(time);
    }
}
