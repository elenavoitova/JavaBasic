package hw10;

import hw10.serviceLayer.FamilyController;

public class Main {
    public static void main(String[] args) {
        FamilyController dataService = new FamilyController();

        Woman mother = new Woman("Julia", "Ivanova", "21/12/1983");
        Man father = new Man("name1", "surname", "20/12/1987");
        Human child = new Human("Child", "Child", "21/12/2020");
        Human child2 = new Human("Child1", "Child", "21/12/1983");
        Family ivanov = new Family(mother, father);

        Human child3 = new Human("Child1", "Child", "20/12/2020", 3);
        child.describeAge();
        System.out.println(mother);
        System.out.println(father);


        Pet dog = new Dog("bobby");
        ivanov.setPet(dog);
        mother.feedPet(true);

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
