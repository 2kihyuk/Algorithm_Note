package test;

import java.util.*;

public class Animal {

    int a = 10;

    void eat(){
        System.out.println("Animal Eat");
    }
    void bark(){
        System.out.println("Animal bark");
    }
}

class Dog extends Animal{
    int a= 20;

    void bark(){
        System.out.println("Dog Bark");
    }

//    void eat(){
//        System.out.println("Dog Eat");
//    }
}

class OTest{
    public static void main(String[] args) {
//        Animal animal = new Dog();
//        System.out.println(animal.a);
//        animal.bark();
//        animal.eat();
//
//        if(animal instanceof Dog){
//            Dog d = (Dog)animal;
//            System.out.println(d.a);
//            d.eat();
//            d.bark();
//        }
//
//        int a = 5;
//        System.out.println(a+=10);
//        System.out.println(a+=10);
//        System.out.println(a);

        HashSet<Character> set = new HashSet<>();
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        Iterator<Character> i =  set.iterator();

        while(i.hasNext()){
            System.out.println(i.next().toString());
        }

        HashMap<String,String> map = new HashMap<>();
        map.put("hi","hello");
        map.put("hi2","hello2");
        map.put("hi3","hello3");
        map.put("hi4","hello4");

        System.out.println(map.get("hi"));

        Iterator<String> ii = map.keySet().iterator();

        while(ii.hasNext()){
            String key = ii.next();
            String value = map.get(key);
            System.out.println(key + " " + value);
        }

        ArrayList<Animal> list = new ArrayList<>();

        Collections.sort(list, (o1, o2) -> Integer.compare(o1.a,o2.a));


    }
}
