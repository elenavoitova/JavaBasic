package hw08;

import java.util.HashSet;
import java.util.Objects;

public class Dog extends Pet implements Troublemaker {

    public Dog() {
        super();
    }

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public void foul() {
        System.out.printf("%s: %s%n", super.getSpecies().getEmoji(), foulFormat);
    }

    @Override
    public void respond() {
        System.out.println(Pet.setRespondFormat(getNickname(), super.getSpecies().getEmoji()));
    }


//    @Override
//    public String toString() {
//        return Pet.setToStringFormat(super.getSpecies(), getNickname(), getAge(), getTrickLevel(), getHabits());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(super.getSpecies(), dog.getSpecies()) &&
               Objects.equals(getNickname(), dog.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getSpecies(), getNickname());
    }

}
