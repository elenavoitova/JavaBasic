package hw10;


import hw10.enums.DayOfWeek;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Human {
    private Family family;
    private Human mother;
    private Human father;
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private final HashMap<DayOfWeek, String> schedule = new HashMap<>();


    public Human() {
    }

    public Human(String name, String surname, String birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = parseBirthdate(birthdate);
    }

    public Human(String name, String surname, String birthdate, Human mother, Human father){
        this.name = name;
        this.surname = surname;
        this.birthDate = parseBirthdate(birthdate);
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = parseBirthdate(birthDate);
        this.iq = iq;
    }

    public Human(String name, String surname, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
    }

    static{
        System.out.println("New class is loaded: " + Human.class.getSimpleName());
    }

    {
        System.out.println("New Object is created: " + this.getClass().getSimpleName());
    }

    public void greetPet(){
        System.out.printf("Привет, %s%n", this.family.getRandomPet().getNickname());
    }


    public boolean feedPet(boolean feedTime){
        Random random = new Random();
        int randomTrick = random.nextInt(Pet.TRICK_LEVEL_MAX);
        if(randomTrick < this.family.getRandomPet().getTrickLevel()){
            System.out.printf("Хм... покормлю ка я %s%n", this.family.getRandomPet().getNickname());
            return true;
        }

        System.out.printf("Думаю, %s не голоден.%n", this.family.getRandomPet().getNickname());
        return false;
    }

    public void describePet(){
        String trickLevel = this.family.getRandomPet().getTrickLevel() < (Pet.TRICK_LEVEL_MAX / 2) ? "почти не хитрый" : "очень хитрый";
        System.out.printf("У меня есть %s, ему %d лет, он %s%n", this.family.getRandomPet().getSpecies(), this.family.getRandomPet().getAge(), trickLevel);
    }

    public String birthDateToString() {
        LocalDate date = Instant.ofEpochMilli(this.birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        return  date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }

    public String describeAge(){
        LocalDate date = Instant.ofEpochMilli(this.birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        int deltaYear = this.getYears();
        int deltaMonth = today.getMonthValue() - date.getMonthValue();
        int deltaDay = today.getDayOfMonth() - date.getMonthValue();
        return deltaYear + " years " + deltaMonth + " months " + deltaDay + " ";
    }

    public long parseBirthdate(String strDate) {
        long parsed = System.currentTimeMillis();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date date = formatter.parse(strDate);
            parsed = date.getTime();
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }

        return parsed;
    }

    public int getYears(){
        LocalDate date = Instant.ofEpochMilli(this.birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        return today.getYear() - date.getYear();
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

    public long getBirthDate() {
        return this.birthDate;
    }

    public void setYear(long birthdate) {
        this.birthDate = birthdate;
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

    public HashMap <DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(DayOfWeek key, String value) {
        this.schedule.put(key, value);
    }



    public String toStringFormat(String type){
        return String.format("%s {name='%s'; surname='%s'; birthDate=%s; iq=%d; schedule=[%s]};",
                type, this.name, this.surname, this.birthDateToString(), this.iq, this.schedule);
    }

    @Override
    public String toString() {
        return toStringFormat("Human");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, birthDate);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Object type %s has been removed by garbage collector%n", getClass());
    }
}
