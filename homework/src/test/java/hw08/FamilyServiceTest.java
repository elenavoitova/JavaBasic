package hw08;

import hw08.serviceLayer.DAO.FamilyService;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {
    FamilyService db = new FamilyService();

    @BeforeEach
    public void setUp() {
        //db initialization
            db.createNewFamily(new Woman("Julia", "Petrova", 1987), new Man("Pavel", "Petrov", 1982));
            db.createNewFamily(new Woman("Julia", "Sidorova", 1987), new Man("Pavel", "Sidorov", 1982));
            db.createNewFamily(new Woman("Julia", "Ivanova", 1987), new Man("Pavel", "Ivanov", 1982));
            db.bornChild(db.getFamilyById(0), "Olga", "Slava");
            System.out.println();

        System.out.println("test start");
    }

    @AfterEach
    void tearDown() {
        db = null;
        System.out.println("test end");
    }

    @Test
    void getAllFamiliesTest(){
        List<Family> actual = db.getAllFamilies();
        assertFalse(actual.isEmpty());
    }

    @Test
    void getFamiliesBiggerThanTest(){
        List<Family> actual = db.getFamiliesBiggerThan(2);
        assertTrue(actual.contains(db.getFamilyById(0)));
        assertEquals(1, actual.size());
    }

    @Test
    void getFamiliesLessThanTest(){
        List<Family> actual = db.getFamiliesLessThan(3);
        assertTrue(actual.contains(db.getFamilyById(1)));
        assertEquals(2, actual.size());
    }

    @Test
    void countFamiliesWithMemberNumberTest(){
        List<Family> actual = db.countFamiliesWithMemberNumber(1);
        assertTrue(actual.isEmpty());
    }

    @Test
    void createNewFamilyTest(){
        int actual = db.count();
        Woman mother = new Woman();
        Man father = new Man();
        db.createNewFamily(mother, father);
        assertEquals(db.count(), actual + 1);
    }

    @Test
    void deleteFamilyByIndexPositiveTest(){
        Family family = new Family(new Woman("Julia", "Sidorova", 1987), new Man("Pavel", "Sidorov", 1982));
        db.deleteFamilyByIndex(1);
        assertFalse(db.getAllFamilies().contains(family));
    }

    @Test
    void deleteFamilyByIndexNegativeTest(){
        int index = db.count();
        db.deleteFamilyByIndex(index + 1);
        assertEquals(db.count(), index);
    }

    @Test
    void bornChildPositiveTest(){
        db.bornChild(db.getFamilyById(2), "test1", "test2");
        String name = db.getFamilyById(2).getChild().get(db.getFamilyById(2).getChild().size() - 1).getName();
        assertFalse(db.getFamilyById(2).getChild().isEmpty(), "bornChild failed");
        assertTrue(name.equals("test1") || name.equals("test2"), "bornChild failed");
    }

    @Test
    void bornChildNegativeTest(){
        assertThrows(NullPointerException.class,() -> db.bornChild(db.getFamilyById(5), "test1", "test2"));
    }

    @Test
    void adoptChildPositiveTest(){
        db.adoptChild(db.getFamilyById(2), new Human("child", "child", 10));
        String name = db.getFamilyById(2).getChild().get(db.getFamilyById(2).getChild().size() - 1).getName();
        assertFalse(db.getFamilyById(2).getChild().isEmpty(), "adoptChild failed");
        assertEquals("child", name, "adoptChild failed");
    }

    @Test
    void adoptChildNegativeTest(){
        assertThrows(NullPointerException.class,() -> db.adoptChild(db.getFamilyById(5), new Human("child", "child", 10)));
    }

    @Test
    void deleteAllChildrenOlderThenTest(){
        db.adoptChild(db.getFamilyById(2), new Human("child", "child", 10));
        db.adoptChild(db.getFamilyById(2), new Human("child", "child", 7));
        db.adoptChild(db.getFamilyById(2), new Human("child", "child", 5));
        db.deleteAllChildrenOlderThen(7);
        assertEquals(2, db.getFamilyById(2).getChild().size(), "deleteAllChildrenOlderThen works incorrectly");
    }

    @Test
    void countIncreaseTest() {
        int count = db.count();
        db.createNewFamily(new Woman("Julia", "Fam", 1987), new Man("Pavel", "Fam", 1982));
        assertEquals(count + 1, db.count());
    }

    @Test
    void countDeceaseTest() {
        int count = db.count();
        db.deleteFamilyByIndex(1);
        assertEquals(count - 1, db.count());
    }

    @Test
    void getPetsTest() {
        Pet dog = new Dog("rocky");
        db.addPet(1, dog);
        System.out.println(db.getFamilyById(1).getPet());
        assertEquals("[Pet{species=DOG, nickname='rocky', age=0, trickLevel=0, habits=[]}]", db.getFamilyById(1).getPet().toString());
    }

    @Test
    void addPetTest() {
        Pet dog = new Dog("rocky");
        db.addPet(1, dog);
        assertTrue(db.getFamilyById(1).getPet().contains(dog));
    }
}
