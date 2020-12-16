package hw07;

import java.util.Random;

public interface HumanCreator {
    Human bornChild();

    default String getChildName(boolean sex){
        String[] girls = new String[] {"Anna","Alina", "Elena", "Kate"};
        String[] boys = new String[] {"Slava","Petr", "Vitalii", "Igor"};

        Random random = new Random();
        int randName = random.nextInt(4);

        return sex ? boys[randName] : girls[randName];
    }
}
