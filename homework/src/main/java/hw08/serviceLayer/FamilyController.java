package hw08.serviceLayer;

import hw08.Family;
import hw08.Human;
import hw08.Pet;
import hw08.serviceLayer.DAO.FamilyService;

import java.util.HashSet;
import java.util.List;

public class FamilyController {
    private final FamilyService service = new FamilyService();

//    public FamilyController(){
//
//    }

    public void displayAllFamilies(){
        this.service.displayAllFamilies();
    }

    public List<Family> getAllFamilies(){
        return this.service.getAllFamilies();
    };

    public List<Family> getFamiliesBiggerThan(int index){
        return this.service.getFamiliesBiggerThan(index);
    }

    public List<Family> getFamiliesLessThan(int index){
        return this.service.getFamiliesLessThan(index);
    }

    public List<Family> countFamiliesWithMemberNumber(int index){
        return this.service.countFamiliesWithMemberNumber(index);
    }

    public void createNewFamily(Human m, Human f){
        this.service.createNewFamily(m, f);
    }

    public void deleteFamilyByIndex(int index){
       this.service.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String girlName, String boyName){
       this.service.bornChild(family, girlName, boyName);
    }

    public Family adoptChild(Family family, Human child){
        return this.service.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int index){
       this.service.deleteAllChildrenOlderThen(index);
    }

    public int count(){
        return this.service.count();
    }

    public Family getFamilyById(int index){
       return this.service.getFamilyById(index);
    }

    public HashSet<Pet> getPets(int index){
        return this.service.getPets(index);
    }

    public void addPet(int index, Pet p){
        this.service.addPet(index, p);
    }
}
