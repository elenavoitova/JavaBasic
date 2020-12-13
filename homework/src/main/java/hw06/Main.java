package hw06;

import hw06.enums.Species;
import hw06.pets.Dog;
import hw06.pets.DomesticCat;
import hw06.pets.Fish;
import hw06.pets.RoboCat;
//import hw06.pets.RoboCat;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Test finalize
//        int i = 0;
//        while(i <= 100000){
//            Human h = new Human("Julia", "Ivanova", 1987);
//            Pet p = new Pet();
//            i++;
//        }

        Woman mother = new Woman("Julia", "Ivanova", 1987);
        Man father = new Man("Pavel", "Ivanov", 1982);






        Family ivanov = new Family(mother, father);
        Pet dog = new Dog("bobby");

        mother.setPet(dog);
        mother.describePet();
        Human ch = ivanov.bornChild();
        System.out.println(ch);


        Dog animal1 = new Dog("buddy");
        DomesticCat animal2 = new DomesticCat("kitty");
        Fish animal3 = new Fish( "noName");
        RoboCat animal4 = new RoboCat("E85s PRO");
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal4);
        animal1.respond();
        animal2.respond();
        animal3.respond();
        animal4.respond();
        animal1.foul();
        animal2.foul();

        mother.greetPet();
        mother.makeup();

    }
}
