package org.learning.Generics;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class WildCards {

    public static void main(String[] args) {

        Animal a = new Animal();

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        animalList.add(new Cat());
        animalList.add(new Dog());

        withoutwildcard(animalList);

        List<Dog> dogList = new ArrayList<>();
        animalList.add(new Dog());
        animalList.add(new Dog());
        animalList.add(new Dog());

        /*  withoutwildcard(dogList);

        We can't pass the list of dogs onto the animal list.
        Alternatively we can create separate functions for each child classes.
        To overcome this issue we can use Wildcards to allow child class's object or parent class's object
         */

        wildcardsExtends(dogList);

        List<Animal> AnimalListsDog = new ArrayList<>();
        AnimalListsDog.add(new Animal());
        AnimalListsDog.add(new Animal());
        AnimalListsDog.add(new Animal());

        wildcardsSuper(AnimalListsDog);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new Cat());
        catList.add(new Cat());

        /*
            wildcardsSuper(catList);

            This line won't work as cat class is not a super class of Dog
         */
    }

    public static void withoutwildcard(List<Animal> animalList){

    }

    public static void wildcardsExtends(List<? extends Animal> animals){

    }

    public static void wildcardsSuper(List<? super Dog> animals){

    }
}
