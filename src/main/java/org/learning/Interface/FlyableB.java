package org.learning.Interface;

public interface FlyableB {

    default void doNothing(){
        System.out.println("Flyable-B");
    }

    void fly();
}
