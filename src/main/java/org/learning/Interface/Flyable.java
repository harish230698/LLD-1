package org.learning.Interface;

public interface Flyable {

    default void doNothing() {
        System.out.println("Flyable-A");
    }

    void fly();


}
