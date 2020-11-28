package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;
    public static int trickLevelMax = 100;
    public static int trickLevelMin = 0;

    public Pet() {
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.habits = habits;
        if(trickLevelMin < 0 || trickLevelMax > 100){
            System.out.println("trick level should be in range 0 - 100");
        } else {
            this.trickLevel = trickLevel;
        }
    }

    static{
        System.out.println("New class is loaded: " + Pet.class);
    }

    {
        System.out.println("New Object is created: " + this.getClass());
    }

    public void eat(){
        System.out.println("Я кушаю!");
    }

    public void respond(){
        System.out.println("Привет, хозяин. Я - " + this.nickname + ". Я соскучился!");
    }

    public void foul(){
        System.out.println("Нужно хорошо замести следы...");
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if(trickLevel < 0 || trickLevel > 100){
            System.out.println("trick level should be in range 0 - 100");
            return;
        }
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname);
    }
}
