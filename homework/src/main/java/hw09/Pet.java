package hw09;



import hw09.enums.Species;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private HashSet <String> habits = new HashSet<>();
    public static final int TRICK_LEVEL_MAX = 100;
    public static final int TRICK_LEVEL_MIN = 0;

    static{
        System.out.println("New class is loaded: " + Pet.class.getSimpleName());
    }

    {
        System.out.println("New Object is created: " + this.getClass().getSimpleName());

        try {
            species = Species.valueOf(this.getClass().getSimpleName().toUpperCase());
        } catch(IllegalArgumentException ex){
            species = Species.UNKNOWN;
        }

    }

    public Pet() {
    }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, HashSet <String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.habits = habits;
        this.trickLevel = Pet.trickLevelFilter(trickLevel);
    }

    public static String setToStringFormat(Species species, String nickname, int age, int trickLevel, String[] habits){
        return String.format("\033[1;30m %s %s {\033[0m %n nickname: %s, %n age: %d %n can fly: %s %n fur: %s %n legs: %d, %n trickLevel: %d,%n habits: %s %n\033[1;30m}\033[0m;", species.getEmoji(), species, nickname, age, species.isCanFly(), species.isHasFur(), species.getNumberOfLegs(), trickLevel, Arrays.toString(habits));
    }

    @Override
    public String toString() {
        return MessageFormat.format("Pet'{'species={0}, nickname=''{1}'', age={2}, trickLevel={3}, habits={4}'}'", this.species, this.nickname, this.age, this.trickLevel, this.habits);
    }

    public static String setRespondFormat(String name, String emoji){
        return String.format("%s: \"Привет, хозяин. Я - \033[1;32m %s\033[0m. Я соскучился!\"%n", emoji, name);
    }

    public static int trickLevelFilter(int lvl){
        if(lvl < TRICK_LEVEL_MIN || lvl > TRICK_LEVEL_MAX){
            System.out.println("\u001B[31mTrick level should be in range 0 - 100\u001B[0m");
            System.out.println("Currently we assign \033[1;30mmedium\u001B[0m trick level to your pet. You could change it further");
            lvl = TRICK_LEVEL_MAX / 2;
        }

        return lvl;
    }

    public void eat(){
        System.out.println("Я кушаю!");
    }

    public abstract void respond();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Object type %s has been removed by garbage collector%n", getClass());
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
        this.trickLevel = Pet.trickLevelFilter(trickLevel);
    }

    public HashSet <String> getHabits() {
        return habits;
    }

    public void setHabits(HashSet <String> habits) {
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
