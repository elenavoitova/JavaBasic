package hw04;

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Julia", "Ivanova", 1987);
        Human father = new Human("Pavel", "Ivanov", 1982);
        Human child = new Human("Slava", "Ivanov", 2013);
        Pet puppy = new Pet("jack-rassel", "Archi", 2, 45, new String[]{"habit1", "habit2"});
        child.setMother(mother);
        child.setFather(father);
        child.setPet(puppy);

        System.out.println(mother);
        System.out.println(father);
        System.out.println(child);
    }
}
