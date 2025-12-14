package org.learning.polymorphism;

public class client {

    public static void main(String[] args) {
        Parent p = new Parent();

        p.display();

        child c = new child();
        c.display();

        Parent pc = new child();

        pc.display();
    }
}
