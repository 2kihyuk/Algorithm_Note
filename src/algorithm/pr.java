package algorithm;

import java.util.Arrays;

public class pr {

    public static void main(String[] args) {
        String str = "30120122";
        int result = 0;
        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            int num = c-'0';
            result = result * 10 + num;
        }
        System.out.println(result);

        int result2 = Integer.valueOf(str);
        System.out.println(result2);

        int result3 = Integer.parseInt(str);
        System.out.println(result3);

        int[] arr ={result,result2,result3};

        int []newArr = new int[5];
        System.arraycopy(arr,0,newArr,0,arr.length);

        newArr[3] = 10; newArr[4] = 20;
        System.out.println(Arrays.toString(newArr));
        System.out.println(newArr);
        System.out.println(newArr.toString());

    }
}
