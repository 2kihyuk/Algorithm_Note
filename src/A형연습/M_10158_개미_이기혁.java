package A형연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_10158_개미_이기혁 {

    private static int w;
    private static int h;
    private static int p;
    private static int q;
    private static int t;



    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        int startX = w - p + 1;
        int startY = h - q + 1;

        int a = startX + t;
        int b = startY + t;

        a = a % (2*w);
        b = b % (2*h);

        System.out.println((w+a - 1) + " " +(h+ b -1));

    }
}
