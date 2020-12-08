package hw05;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.StringJoiner;

public class Human {
    private Family family;
    private Human mother;
    private Human father;
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Pet pet;



    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.father = father;
        this.mother = mother;
    }

    static{
        System.out.println("New class is loaded: " + Human.class);
    }

    {
        System.out.println("New Object is created: " + this.getClass());
    }

    public void greetPet(){
        System.out.printf("Привет, %s%n", this.pet.getNickname());
    }

    public boolean feedPet(boolean feedTime){
        Random random = new Random();
        int randomTrick = random.nextInt(Pet.TRICK_LEVEL_MAX);
        if(randomTrick < this.pet.getTrickLevel()){
            System.out.printf("Хм... покормлю ка я %s%n", pet.getNickname());
            return true;
        }

        System.out.printf("Думаю, %s не голоден.%n", this.pet.getNickname());
        return false;
    }

    public void describePet(){
        String trickLevel = this.pet.getTrickLevel() < (Pet.TRICK_LEVEL_MAX / 2) ? "почти не хитрый" : "очень хитрый";
        System.out.printf("У меня есть %s, ему %d лет, он %s%n", this.pet.getSpecies(), this.pet.getAge(), trickLevel);
    }


    //Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Pet getPet(){
        return pet;
    }

    public void setPet(Pet pet){
        this.pet = pet;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if(iq < 0 || iq > 100) {
            System.out.println("iq should be in range 0 - 100");
            return;
        }
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }



    //Overrides

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule=[%s]}", name, surname, year, iq, Arrays.toString(schedule));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, year);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Object type %s has been removed by garbage collector%n", getClass());
    }
}
