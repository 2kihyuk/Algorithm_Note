package SSAFY_Algo_0805;

import java.util.Arrays;
import java.util.Scanner;

//순열. 순서가 있는 나열.
public class PermutationInputTest {
    static int N;
    static int R;
    static int totalCnt;
    static boolean[] isSelected;
    static int[] input;
    static int[] numbers;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        numbers = new int[R];
        isSelected = new boolean[N];

        for(int i =0;i <N;i++){
            input[i] = sc.nextInt();
        }

        permutation(0);

        System.out.println("총 개수는 :" + totalCnt);
    }
    private static void permutation(int cnt){

        if(cnt == R){
            System.out.println(Arrays.toString(numbers));
            totalCnt++;
            return;
        }

        for(int i = 0; i<N;i++){

            if(isSelected[i]){
                continue;
            }

            numbers[cnt] = input[i];
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;

        }
    }
}
