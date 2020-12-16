package hw07;

public final class Woman extends Human {
    public final String emoji = "\uD83D\uDC67";

    public Woman(){
        super();
    }

    public Woman(String name, String surname, int year){
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, Human mother, Human father){
        super(name, surname, year, mother, father);
    }

    public void makeup(){
        System.out.printf("%s %s: \"А я ниче так\"%n", emoji, getName());
    }

    @Override
    public void greetPet() {
        if(getPet() == null) System.out.printf("%s don't have a pet yet", getName());
        else {
            System.out.printf("%s %s: \"Привет, %s!\"%n", emoji, getName(), getPet().getNickname());
        }
    }

    @Override
    public String toString() {
        return toStringFormat("Woman");
    }
}
