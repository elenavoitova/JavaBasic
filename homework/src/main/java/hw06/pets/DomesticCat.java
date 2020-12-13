package hw06.pets;

import hw06.Pet;
import hw06.Troublemaker;
import hw06.enums.Species;

import java.util.Objects;

public class DomesticCat extends Pet implements Troublemaker {

    public DomesticCat() {
        super();
        super.setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        super.setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.CAT);
    }

    @Override
    public void respond() {
        System.out.println(Pet.setRespondFormat(getNickname(), super.getSpecies().getEmoji()));
    }

    @Override
    public void foul() {
        System.out.printf("%s: %s%n", super.getSpecies().getEmoji(), foulFormat);
    }

    @Override
    public String toString() {
        return Pet.setToStringFormat(super.getSpecies(), getNickname(), getAge(), getTrickLevel(), getHabits());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomesticCat cat = (DomesticCat) o;
        return Objects.equals(super.getSpecies(), cat.getSpecies()) &&
                Objects.equals(getNickname(), cat.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getSpecies(), getNickname());
    }
}
