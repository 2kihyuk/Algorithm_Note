package class_0721;

import java.util.Arrays;

public class array_pr2 {

    public static void main(String[] args) {
        ///숫자를 몇번썼는지 체크하는..

        int[] intArr = {3,7,2,5,7,7,9,2,8,1,1,5,3};
        int []used = new int[10];

        for(int i=0; i<intArr.length;i++){
            used[intArr[i]]++;
        }

        ///사용되지 않은 숫자를 체크하는..
        int[] notUsed = new int[10];

        for(int i=0; i<notUsed.length; i++){
            if(used[i] == 0){
                notUsed[i]++;
            }
        }

        System.out.println(Arrays.toString(used));
        System.out.println(Arrays.toString(notUsed));
    }
}
