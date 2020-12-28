package hw10.serviceLayer.DAO;

import java.util.List;

public interface FamilyDao<Family> {

    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    Family getFamilyBySurname(String surname);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family f);
    void saveFamily(Family f);


}
