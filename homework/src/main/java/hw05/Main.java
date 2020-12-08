package hw05;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Test finalize
//        int i = 0;
//        while(i <= 100000){
//            Human h = new Human("Julia", "Ivanova", 1987);
//            Pet p = new Pet();
//            i++;
//        }

        Human mother = new Human("Julia", "Ivanova", 1987);
        Human father = new Human("Pavel", "Ivanov", 1982);

        Human mother1 = new Human("Julia", "Ivanova", 1987);
        Human father1 = new Human("Pavel", "Ivanov", 1982);

        Human child1 = new Human("Slava", "Ivanov", 2013);
        Human child2 = new Human("Vova", "Ivanov", 2010);
        Human child3 = new Human("Vova", "Petrov", 2010);

        Family ivanov = new Family(mother, father);
        ivanov.addChild(child1);
        ivanov.addChild(child2);

        Family petrov = new Family(mother1, father1);
        petrov.addChild(child3);

        ivanov.deleteChild(child3);
        ivanov.deleteChild(child2);
        ivanov.deleteChild(13);
        System.out.println(Arrays.toString(ivanov.getChild()));
    }
}
