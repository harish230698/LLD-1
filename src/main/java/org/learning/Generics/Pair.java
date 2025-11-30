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
        this.key=key;
        this.value=value;
    }

    public U getValue(T key){
        return this.value;
    }

    public static void main(String[] args) {

        Pair<Integer,String> p1 = new Pair<>();
        p1.addkeyvalue(1,"Harish");
        p1.addkeyvalue(2,"Hans");

        System.out.println(p1.getValue(1));
        System.out.println(p1.getValue(2));

    }
}