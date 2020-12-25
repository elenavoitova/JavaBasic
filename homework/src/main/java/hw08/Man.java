package hw08;

public final class Man extends Human {
    public final String emoji = "\uD83E\uDDD4";
    public Man(){
        super();
    }

    public Man(String name, String surname, int year){
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, Human mother, Human father){
        super(name, surname, year, mother, father);
    }

    public void repairCar(){
        System.out.printf("%s %s: \"Машина как новенькая теперь\"%n", emoji, getName());
    }

//    @Override
//    public void greetPet() {
//        if(getPet() == null) System.out.printf("%s don't have a pet yet", getName());
//        else {
//            System.out.printf("%s %s: \"Привет, %s!\"%n", emoji, getName(), getPet().getNickname());
//        }
//    }

    @Override
    public String toString() {
        return toStringFormat("Man");
    }
}
