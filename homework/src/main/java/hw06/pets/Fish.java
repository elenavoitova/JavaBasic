package hw06.pets;

import hw06.Pet;
import hw06.enums.Species;

import java.util.Objects;

public class Fish extends Pet {
    private Species species;

    public Fish() {
        super();
    }

    public Fish(Species species, String nickname) {
        super(nickname);
        this.species = species;
    }

    public Fish(Species species, String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = species;
    }

    @Override
    public void respond() {
        System.out.println(Pet.setRespondFormat(getNickname(), species.getEmoji()));
    }


    @Override
    public String toString() {
        return Pet.setToStringFormat(species, getNickname(), getAge(), getTrickLevel(), getHabits());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return Objects.equals(species, fish.species) &&
                Objects.equals(getNickname(), fish.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, getNickname());
    }

    @Override
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
