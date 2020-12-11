package hw06;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private Human[] children = new Human[0];
    private Pet[] pet = new Pet[0];
    private int countFamily = 2;

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
        this.children = increaseHumanArr(this.children, child);
        child.setFamily(this);
        countFamily++;
    }

    public void deleteChild(Human child){
        if(this != child.getFamily()){
            System.out.println("It's not my child");
            return;
        }

        this.children = decreaseHumanArr(this.children, child);
        System.out.println("Goodbye " + child.getName());
        child.setFamily(null);
        countFamily--;
    }

    public void deleteChild(int index) {
        System.out.println("index" + index);
        if(index >= children.length){
            System.out.println("We don't have so match children");
            return;
        }
        children[index].setFamily(null);
        countFamily--;
        System.out.println(index + " th child have been deleted from Family " + this);
        this.children = decreaseHumanArr(this.children, index);
    }

    private Human[] increaseHumanArr(Human[] ps, Human p) {
        Human[] increasedArr = Arrays.copyOf(ps, (ps.length + 1));
        increasedArr[ps.length] = p;

        return increasedArr;
    }

    private Human[] decreaseHumanArr(Human[] ps, Human p){
        Human[] decreasedArr = new Human[ps.length - 1];

        for (int i = 0, k = 0; i < ps.length ; i++) {
            if(!ps[i].equals(p)) decreasedArr[k++] = ps[i];
        }
        return decreasedArr;
    }

    private Human[] decreaseHumanArr(Human[] ps, int index){
        Human[] decreasedArr = new Human[ps.length - 1];

        for (int i = 0, k = 0; i < ps.length ; i++) {
            if(index != i) decreasedArr[k++] = ps[i];
        }
        return decreasedArr;
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

    public Human[] getChild() {
        return children;
    }

    public Pet[] getPet() {
        return pet;
    }

    public void setPet(Pet[] pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Family'{'mother={0}, father={1}, children={2}, pet={3}, countFamily={4}'}'", mother, father, Arrays.toString(children), Arrays.toString(pet), countFamily);
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


