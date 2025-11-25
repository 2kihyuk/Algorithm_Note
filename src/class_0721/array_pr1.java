package class_0721;

import java.util.Arrays;

public class array_pr1 {

    public static void main(String[] args) {
        int []arr = {0,1,2,3,4,5,6,7,8,9};
        int []brr = {0,0,0,0,0,0,0,0,0,0};

        System.arraycopy(arr,2,brr,1,3);
        ///arraycopy(원본배열,원본배열의 시작인덱스, 대상배열, 대상배열의 시작위치, 복사할 요소 수)
        System.out.println(Arrays.toString(brr));

        int[] newArr = Arrays.copyOf(arr,5);

        //Arrays.copyOf(원본배열 , 0번인덱스부터 몇개의 요소인지)
        System.out.println(Arrays.toString(newArr));

        //부분 복사하고 싶으면 → System.arraycopy()

        //앞에서부터 새 배열로 복사하고 싶으면 → Arrays.copyOf()

    }
}
