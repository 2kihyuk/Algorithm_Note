package test;

import com.sun.tools.javac.Main;

public class Customer {
    String name;
    String region;
    int age;

    public Customer(String name, String region, int age){
        this.name = name;
        this.region = region;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "name='" + name + '\'' +
//                ", region='" + region + '\'' +
//                ", age=" + age +
//                '}';
//    }
}


class MainCustomer extends Customer{

    String purpose;

    public MainCustomer(String name, String region, int age , String purpose) {
        super(name, region, age);
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "MainCustomer{" +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", age=" + age + '\'' +
                "purpose='" + purpose +
                '}';
    }
}

class PolyTest{
    public static void main(String[] args) {
        Customer c = new Customer("홍길동", "서울", 20);
        System.out.println(c);

        MainCustomer cc = new MainCustomer("김싸피","부산", 25, "여행");
        System.out.println(cc);

        Customer ccc = new MainCustomer("이싸피","인천",25,"취업");
        System.out.println(ccc);
    }
}
