package hw10.serviceLayer.DAO;

import hw10.Family;
import hw10.Human;
import hw10.Pet;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private final FamilyDao<Family> data = CollectionFamilyDao.getInstance();

    public void displayAllFamilies(){
        System.out.println(data.getAllFamilies());
    }

    public List<Family> getAllFamilies(){
        return data.getAllFamilies();
    };

    private void _exceptionHandler() {
        StackTraceElement calledHandlerFunc = Thread.currentThread().getStackTrace()[2];
        System.out.printf("something goes wrong. Operation: %s\n", calledHandlerFunc.getMethodName());
    }

    public List<Family> getFamiliesBiggerThan(int index){
        return data.getAllFamilies().stream()
                .filter(f -> f.getCountFamily() > index).collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int index){
        return data.getAllFamilies().stream()
                .filter(f -> f.getCountFamily() < index).collect(Collectors.toList());
    }

    public List<Family> countFamiliesWithMemberNumber(int index){
        return data.getAllFamilies().stream()
                .filter(f -> f.getCountFamily() == index).collect(Collectors.toList());
    }

    public void createNewFamily(Human m, Human f){
        this.data.saveFamily(new Family(m, f));
    }

    public void deleteFamilyByIndex(int index){
        boolean result = this.data.deleteFamily(index);
        if(!result) this._exceptionHandler();
    }

    public void bornChild(Family family, String girlName, String boyName){
        family.bornChild(girlName, boyName);
        this.data.saveFamily(family);
    }

    public Family adoptChild(Family family, Human child){
        family.addChild(child);
        this.data.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int index){
        for(Family f: this.getAllFamilies()){
            f.getChild().removeIf(child -> child.getYears() > index);
        }
    }

    public int count(){
        return this.getAllFamilies().size();
    }

    public Family getFamilyById(int index){
        Family family = null;
        try{
            family =  this.getAllFamilies().get(index);
        }catch (Exception e){
            this._exceptionHandler();
        }

        return family;
    }

    public HashSet<Pet> getPets(int index){
        return this.getFamilyById(index).getPets();
    }

    public void addPet(int index, Pet p){
        this.getFamilyById(index).setPet(p);
    }


}
