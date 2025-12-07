package org.practice.Generics;

public class GenericPair<K,V> {

    private final K first;
    private final V second;


    public GenericPair(K first, V second) {
        this.first = first;
        this.second = second;
    }


    public K getFirst() {
        return first;
    }


    public V getSecond() {
        return second;
    }

    public static void main(String[] args) {
        GenericPair<String, Integer> pair = new GenericPair("One", 1);
        System.out.println(pair.getFirst() + ", " + pair.getSecond()); // Output: ?
    }

}

