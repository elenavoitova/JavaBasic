package hw10.enums;

public enum Species {
    CAT(false, 4, true, "\uD83D\uDE3A"),
    DOG(false, 4, true, "\uD83D\uDC36"),
    HAMSTER(false, 4, true, "\uD83D\uDC39"),
    FISH(false, 0, false, "\uD83E\uDD88"),
    UNKNOWN("\uD83D\uDC7D");

    boolean canFly;
    int numberOfLegs;
    boolean hasFur;
    String emoji;

    Species(boolean canFly, int numberOfLegs, boolean hasFur, String emoji){
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
        this.emoji = emoji;
    }

    Species(String emoji){
        this.emoji = emoji;
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

    public String getEmoji() {
        return emoji;
    }
}
