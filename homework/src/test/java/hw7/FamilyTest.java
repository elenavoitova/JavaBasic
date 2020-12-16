package hw7;

import hw07.Family;
import hw07.Human;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    static Human mother;
    static Human father;
    static Family family;

    @BeforeEach
    void setUp() {
        mother = new Human("Julia", "Ivanova", 1987);
        father = new Human("Pavel", "Ivanov", 1982);
        family = new Family(mother, father);
        System.out.println("test start");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }

    @AfterEach
    void tearDown() {
        mother = null;
        father = null;
        family = null;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        System.out.println("test end");
    }

    @Test
    void toStringHumanTest(){
        Human child = new Human("Petr", "Ivanov", 2015);
        family.addChild(child);
        String expect = "Family{mother=Human {name='Julia'; surname='Ivanova'; year=1987; iq=0; schedule=[{}]};, father=Human {name='Pavel'; surname='Ivanov'; year=1982; iq=0; schedule=[{}]};, children=[Human {name='Petr'; surname='Ivanov'; year=2015; iq=0; schedule=[{}]};], pet=[], countFamily=3}";
        assertTrue(family.toString().contains(expect));
    }

    @Test
    void addChildTest_checkFamilyCounter() {
        Human child = new Human();
        family.addChild(child);
        assertEquals(3, family.getCountFamily());
    }

    @Test
    void addChildTest_checkChildrenArrayLength() {
        Human child = new Human();
        family.addChild(child);
        assertEquals(1, family.getChild().size());
    }

    @Test
    void addChildTest_addSeveral() {
        Human testChild1 = new Human("child1", "child1", 1);
        Human testChild2 = new Human("child2", "child2", 2);
        Human testChild3 = new Human("child3", "child3", 3);
        family.addChild(testChild1);
        family.addChild(testChild2);
        family.addChild(testChild3);
        for (int i = 1; i < family.getChild().size(); i++) {
            System.out.println(family.getChild().get(i));
            assertNotEquals(family.getChild().get(i), family.getChild().get(i - 1));
        }
    }

    @Test
    void deleteChild_deleteSingle() {
        Human child = new Human("child1", "child1", 2);
        family.addChild(child);
        family.deleteChild(child);
        assertEquals(0, family.getChild().size());
    }

    @Test
    void deleteChild_byIndex() {
        Human child1 = new Human("child1", "child1", 2);
        Human child2 = new Human("child2", "child2", 1);
        Human child3 = new Human("child3", "child3", 1);
        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        family.deleteChild(1);

        for (Human child: family.getChild()) {
            assertNotEquals(child, child2);
        }
    }

    @Test
    void deleteChild_byInvalidIndex() {
        Human child1 = new Human("child1", "child1", 2);
        Human child2 = new Human("child2", "child2", 1);
        Human child3 = new Human("child3", "child3", 1);
        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        family.deleteChild(4);

        assertEquals(3, family.getChild().size());
    }

    @Test
    void deleteChild_deleteAll() {
        Human child1 = new Human("child1", "child1", 1);
        Human child2 = new Human("child2", "child2", 1);
        Human child3 = new Human("child3", "child3", 1);
        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        family.deleteChild(child1);
        family.deleteChild(child2);
        family.deleteChild(child3);
        assertEquals(0, family.getChild().size());

    }

    @Test
    void deleteChild_nonExistingChild() {
        Human child1 = new Human("child1", "child1", 1);
        Human child2 = new Human("child2", "child2", 1);
        family.addChild(child1);
        family.deleteChild(child2);
        assertEquals(family.getChild().get(0), child1);
    }

    @Test
    void deleteChild_fromOtherFamily() {
        Family family2 = new Family(mother, father);
        Human child1 = new Human("child", "child", 1);
        Human child2 = new Human("child", "child", 1);
        family.addChild(child1);
        family2.addChild(child2);
        family.deleteChild(child2);
        assertEquals(family.getChild().get(0), child1);
    }
}
