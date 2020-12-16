package hw07;

import hw07.enums.DayOfWeek;

public class Main {
    public static void main(String[] args) {

        Woman mother = new Woman("Julia", "Ivanova", 1987);
        Man father = new Man("Pavel", "Ivanov", 1982);
        Human child = new Human("Child", "Child", 12);
        Human child2 = new Human("Child1", "Child", 12);

        Family ivanov = new Family(mother, father);
        Pet dog = new Dog("bobby");

       mother.setSchedule(DayOfWeek.Mo, "do thomething");
        System.out.println(mother.getSchedule());

    }
}
