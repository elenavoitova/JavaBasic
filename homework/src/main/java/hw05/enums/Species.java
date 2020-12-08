package hw05.enums;

public enum Species {
    CAT(false, 4, true),
    DOG(false, 4, true),
    HOMSTER(false, 4, true),
    FISH(false, 0, false);

    boolean canFly;
    int numberOfLegs;
    boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur){
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }
}
