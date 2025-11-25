package algorithm;

import java.util.Scanner;
import java.io.FileInputStream;

class swea1959
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int arr[] = new int[a];
            int brr[] = new int[b];

            for(int i =0; i<a;i++){
                arr[i] = sc.nextInt();
            }
            for(int i =0; i<b; i++){
                brr[i] = sc.nextInt();
            }

            int answer = Integer.MIN_VALUE;

            if(b >=a){
                for(int i =0; i<=b-a; i++){
                    int sum = 0;
                    for(int j =0; j<a; j++){
                        sum+=arr[j] * brr[i+j];
                    }
                    answer = Math.max(answer , sum);
                }
            }else{
                for(int i =0; i<=a-b; i++){
                    int sum = 0;
                    for(int j =0; j<b; j++){
                        sum+=brr[j] * arr[i+j];
                    }
                    answer = Math.max(answer , sum);
                }
            }

            System.out.println("#" + test_case + " " + answer );
        }
    }
}