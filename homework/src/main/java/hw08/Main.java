package hw08;

import hw08.serviceLayer.DAO.FamilyService;
import hw08.enums.DayOfWeek;
import hw08.serviceLayer.FamilyController;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyController dataService = new FamilyController();

        Woman mother = new Woman("Julia", "Ivanova", 1987);
        Man father = new Man("Pavel", "Ivanov", 1982);
        Human child = new Human("Child", "Child", 12);
        Human child2 = new Human("Child1", "Child", 12);
        Family ivanov = new Family(mother, father);


        Pet dog = new Dog("bobby");

        dataService.createNewFamily(new Woman("Julia", "Petrova", 1987), new Man("Pavel", "Petrova", 1982));
        dataService.createNewFamily(new Woman("Julia", "Sidorova", 1987), new Man("Pavel", "Sidorova", 1982));
        dataService.createNewFamily(mother, father);

        System.out.println(dataService.getAllFamilies());
        System.out.println(dataService.getFamiliesBiggerThan(3));
        System.out.println(dataService.getFamiliesLessThan(1));
        System.out.println(dataService.countFamiliesWithMemberNumber(2));
        dataService.deleteFamilyByIndex(1);
        dataService.bornChild(ivanov,"Olga", "Andrey");
        dataService.adoptChild(ivanov, child);
        dataService.deleteAllChildrenOlderThen(10);
        System.out.println(dataService.count());
        System.out.println(dataService.getFamilyById(0));
        dataService.addPet(0, dog);
        System.out.println(dataService.getPets(0));
        System.out.println();
        dataService.displayAllFamilies();

    }
}
