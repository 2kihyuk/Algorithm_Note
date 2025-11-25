package test;

import java.util.Arrays;

public class testcode {

    public static void main(String[] args) {
        char [] xarr= {'s','s','a','f','y'};

        System.out.println(xarr);
        System.out.println(Arrays.toString(xarr));
        System.out.println(xarr.toString());

        String[] arr = {"a","b","c","d"};

        System.out.println(Arrays.toString(arr));
        System.out.println(arr);
        System.out.println(arr.toString());

       // arr = {"a","b","c","d","e"};

        //String []arr2 = {"a","b","c","d","e"};

        String []arr3 = new String[5];
        System.arraycopy(arr,0,arr3,0,4);
        arr3[4] = "e";
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3);
        System.out.println(arr3.toString());
    }
}
