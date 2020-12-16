package hw07;

import java.text.MessageFormat;
import java.util.*;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private final ArrayList<Human> children = new ArrayList<>();
    private final HashSet<Pet> pet = new HashSet<>();
    private int countFamily = 2;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
    }

    static{
        System.out.println("New class is loaded: " + Family.class.getSimpleName());
    }

    {
        System.out.println("New Object is created: " + this.getClass().getSimpleName());
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.setFamily(this);
        countFamily++;
    }

    public void deleteChild(Human child){
        if(this != child.getFamily()){
            System.out.println("It's not my child");
            return;
        }

        this.children.remove(child);
        System.out.println("Goodbye " + child.getName());
        child.setFamily(null);
        countFamily--;
    }

    public void deleteChild(int index) {
        if(index >= this.children.size()){
            System.out.println("We don't have so match children");
            return;
        }
        children.get(index).setFamily(null);
        countFamily--;
        System.out.println(index + " th child have been deleted from Family " + this);
        this.children.remove(index);
    }

    @Override
    public Human bornChild() {
        Random random = new Random();
        boolean isBoy = random.nextBoolean();
        String name = getChildName(isBoy);

        int childIQ;
        String childSurname;
        try {
            childIQ = (getFather().getIq() + getMother().getIq()) / 2;
            childSurname = getFather().getSurname();
        } catch (Exception e) {
            throw new NullPointerException("To make a child you should have complete family");
        }


        return isBoy ? new Man(name, childSurname,childIQ) : new Woman(name, childSurname,childIQ);
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

    public int getCountFamily() {
        return countFamily;
    }

    public ArrayList<Human> getChild() {
        return children;
    }

    public HashSet<Pet> getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet.add(pet);
    }

    @Override
    public String toString() {
        return MessageFormat.format("Family'{'mother={0}, father={1}, children={2}, pet={3}, countFamily={4}'}'", mother, father, children, pet, countFamily);
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Object type %s has been removed by garbage collector%n", getClass());
    }
}


