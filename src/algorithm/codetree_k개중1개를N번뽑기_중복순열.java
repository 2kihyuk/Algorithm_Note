package algorithm;
import java.util.Scanner;

public class codetree_k개중1개를N번뽑기_중복순열 {
    private static int[] input;
    private static int[]numbers;
    private static StringBuilder sb;
    private static int n,k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        // Please write your code here.
        sb= new StringBuilder();

        input = new int[k+1];

        for(int i = 1; i<=k; i++){
            input[i] = i;
        }
        numbers = new int[n];

        permu(0);

        System.out.print(sb);
    }

    private static void permu(int cnt){
        if(cnt == n){
            for(int a : numbers){
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i<=k; i++){
            numbers[cnt] = input[i];
            permu(cnt+1);

        }
    }
}
