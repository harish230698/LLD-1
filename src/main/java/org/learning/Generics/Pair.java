package org.learning.Generics;

public class Pair<T,U> {

    private T key;
    private U value;

    Pair(){

    }

    Pair(T key,U value){
        this.key=key;
        this.value=value;
    }

    public void addkeyvalue(T key,U value){
        key=key;
        value=value;
    }

    public U getValue(T key){
        return value;
    }

    public static void main(String[] args) {

        Pair<Integer,String> p1 = new Pair<>(1,"Harish");


        System.out.println(p1.getValue(1));
//        System.out.println(p1.getValue(2));

    }
}