package hw04;

import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;



    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
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

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if(iq < 0 || iq > 100) throw new IllegalArgumentException("iq should be in range 0 - 100");
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", pet=" + pet +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }

    public void greetPet(){
        System.out.println("Привет, " + this.pet);
    }

    public void describePet(){
        String trickLevel = this.pet.getTrickLevel() < (Pet.TRICK_LEVEL_MAX / 2) ? "почти не хитрый" : "очень хитрый";
        System.out.println("У меня есть " + this.pet.getSpecies() + ", ему " + this.pet.getAge() + " лет, он " + trickLevel);
    }

    public boolean feedPet(boolean feedTime){
        Random random = new Random();
        int randomTrick = random.nextInt(Pet.TRICK_LEVEL_MAX);
        if(randomTrick < pet.getTrickLevel()){
            System.out.println("Хм... покормлю ка я " + pet.getNickname());
            return true;
        }

        System.out.println("Думаю, " + pet.getNickname() + " не голоден.");
        return false;
    }
}
