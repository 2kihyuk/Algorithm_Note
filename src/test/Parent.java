package test;

public class Parent {
    int number = 10;

    void over(){
        System.out.println("Parent Class!");
    }
    void mParent(){
        System.out.println("Parent method!");
    }
}

class Child extends Parent{
    int number = 20;

    void over(){
        System.out.println("Child class!");
    }


    void mChild(){
        System.out.println("Child method!");
    }


}

class OverridingTest{
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.number); //10
        parent.over(); //Parent Class
        parent.mParent();//Parent Method

        Child child = new Child();
        System.out.println(child.number); //10
        child.over();//Child Class
        child.mChild();//Child method

        Parent p2 = child;
        System.out.println(p2.number); //10
        p2.over(); // Child class
        p2.mParent(); //Parent method
        //p2.mChild(); //compile error

        Child c2 = (Child)p2;
        c2.mChild(); //Child method

        Parent x = new Child();

        System.out.println(x.number); //10
        x.mParent(); // 오버라이드 시 자식의 mParent , 오버라이드 안하면 부모의 mParent()
        x.over(); // 자식의 over()

//        Object s = "a";
//        Integer i = (Integer)s;
//        System.out.println(i);

        if(child instanceof Parent){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        if(parent instanceof Child){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
