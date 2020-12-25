package hw08.enums;

public enum DayOfWeek {
    Mo("Monday",1, 2),
    Tu("Tuesday", 2, 3),
    We("Wednesday", 3, 4),
    Th("Thursday", 4, 5),
    Fr("Friday", 5, 6),
    Sa("Saturday", 6, 7),
    Su("Sunday", 7, 1);

    String day;
    int orderEurope;
    int orderUSA;

    DayOfWeek(String day, int orderEurope, int orderUSA) {
        this.day = day;
        this.orderEurope = orderEurope;
        this.orderUSA = orderUSA;
    }
}
