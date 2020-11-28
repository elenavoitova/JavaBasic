package hw04;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;
    public static int trickLavelMax = 100;
    public static int trickLavelMin = 0;

    public Pet() {
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        if(trickLavelMin < 0 || trickLavelMax > 100){
            throw new IllegalArgumentException("trick level should be in range 0 - 100");
        }
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
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
        if(trickLevel < 0 || trickLevel > 100){
            throw new IllegalArgumentException("trick level should be in range 0 - 100");
        }
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
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

    public void eat(){
        System.out.println("Я кушаю!");
    }

    public void respond(){
        System.out.println("Привет, хозяин. Я - " + this.nickname + ". Я соскучился!");
    }

    public void foul(){
        System.out.println("Нужно хорошо замести следы...");
    }
}
