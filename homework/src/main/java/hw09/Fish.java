package hw09;

import java.util.HashSet;
import java.util.Objects;

public class Fish extends Pet {

    public Fish() {
        super();
    }

    public Fish(String nickname) {
        super(nickname);
    }

    public Fish(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
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
        Fish fish = (Fish) o;
        return Objects.equals(super.getSpecies(), fish.getSpecies()) &&
                Objects.equals(getNickname(), fish.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getSpecies(), getNickname());
    }
}
