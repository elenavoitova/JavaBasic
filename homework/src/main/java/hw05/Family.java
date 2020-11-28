package hw05;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children = new Human[0];
    private Pet pet;
    private byte countFamily = 2;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
    }

    static{
        System.out.println("New class is loaded: " + Family.class);
    }

    {
        System.out.println("New Object is created: " + this.getClass());
    }

    public void addChild(Human child) {
        Human[] tempChildren = Arrays.copyOf(this.children, (this.children.length + 1));
        tempChildren[this.children.length] = child;
        this.children = tempChildren;
        child.setFamily(this);
        countFamily++;
    }

    public void deleteChild(Human child){
        if(this != child.getFamily()){
            System.out.println("It's not my child");
            return;
        }

        Human[] temp = new Human[children.length - 1];
        for (int i = 0, k = 0; i < children.length ; i++) {
            if(children[i].equals(child)){
                System.out.println("Goodbye " + child.getName());
                child.setFamily(null);
                countFamily--;
            } else{
                temp[k++] = children[i];
            }
        }

        this.children = temp;
    }

    public void greetPet(){
        System.out.println("Привет, " + this.pet);
    }

    public void describePet(){
        String trickLevel = this.pet.getTrickLevel() < (Pet.trickLevelMax / 2) ? "почти не хитрый" : "очень хитрый";
        System.out.println("У меня есть " + this.pet.getSpecies() + ", ему " + this.pet.getAge() + " лет, он " + trickLevel);
    }

    public boolean feedPet(boolean feedTime){
        Random random = new Random();
        int randomTrick = random.nextInt(Pet.trickLevelMax);
        if(randomTrick < pet.getTrickLevel()){
            System.out.println("Хм... покормлю ка я " + pet.getNickname());
            return true;
        }

        System.out.println("Думаю, " + pet.getNickname() + " не голоден.");
        return false;
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

    public byte getCountFamily() {
        return countFamily;
    }

    public Human[] getChild() {
        return children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Family {" + '\n' +
                "\tmother=" + mother + '\n' +
                "\tfather=" + father + '\n' +
                "\tchildren=" + Arrays.toString(children) + '\n' +
                "\tpet=" + pet + '\n' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }
}


