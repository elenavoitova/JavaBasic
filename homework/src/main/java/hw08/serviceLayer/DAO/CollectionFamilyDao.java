package hw08.serviceLayer.DAO;

import hw08.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class CollectionFamilyDao implements FamilyDao<Family> {
    private static final List<Family> DB = new ArrayList<>();
    private static CollectionFamilyDao instance;

    private CollectionFamilyDao(){ }

    public static CollectionFamilyDao getInstance(){
        if(instance == null) instance = new CollectionFamilyDao();

        return instance;
    }

    @Override
    public List<Family> getAllFamilies() {
        return CollectionFamilyDao.DB;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        try {
            return CollectionFamilyDao.DB.get(index);
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public Family getFamilyBySurname(String surname) {
        List<Family> list = DB.stream()
                .filter(f -> f.getFather().getSurname().equals(surname)).collect(Collectors.toList());

        return list.get(0);
    }

    @Override
    public boolean deleteFamily(int index) {
        try {
            CollectionFamilyDao.DB.remove(index);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family f) {
        try {
            CollectionFamilyDao.DB.remove(f);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public void saveFamily(Family f) {
        int presence = CollectionFamilyDao.DB.indexOf(f);
        if(presence == -1){
            CollectionFamilyDao.DB.add(f);
        } else {
            CollectionFamilyDao.DB.set(presence, f);
        }
    }
}
