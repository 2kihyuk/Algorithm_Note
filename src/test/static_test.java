package test;

public class static_test {

    static int count;

    static void setCount(int k){
        count = k;
        System.out.println("SetCount() : " + count);
    }

    static{
        System.out.println("Static Initialize! , count : "+count); //1
    }
    {
        System.out.println("instance Initialize.." + (++count)); //4 6
    }

    public static void main(String[] args) {
        System.out.println("Main Start"); //2
        static_test.setCount(10); //3
        static_test st = new static_test();//4
        System.out.println("Main.."); //5
        static_test st2 = new static_test(); //6

    }
}

