package hw09;

public final class Woman extends Human {
    public final String emoji = "\uD83D\uDC67";

    public Woman(){
        super();
    }

    public Woman(String name, String surname, String birthdate){
        super(name, surname, birthdate);
    }

    public Woman(String name, String surname, String birthdate, Human mother, Human father){
        super(name, surname, birthdate, mother, father);
    }

    public Woman(String name, String surname, int iq) {
        super(name, surname, iq);
    }

    public void makeup(){
        System.out.printf("%s %s: \"А я ниче так\"%n", emoji, getName());
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
        return toStringFormat("Woman");
    }
}
