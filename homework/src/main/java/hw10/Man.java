package hw10;

public final class Man extends Human {
    public final String emoji = "\uD83E\uDDD4";
    public Man(){
        super();
    }

    public Man(String name, String surname, String birthdate){
        super(name, surname, birthdate);
    }

    public Man(String name, String surname, String birthdate, Human mother, Human father){
        super(name, surname, birthdate, mother, father);
    }

    public Man(String name, String surname, int iq) {
        super(name, surname, iq);
    }

    public void repairCar(){
        System.out.printf("%s %s: \"Машина как новенькая теперь\"%n", emoji, getName());
    }

    @Override
    public void greetPet() {
        if(super.getFamily().getPets() == null) System.out.printf("%s don't have a pet yet", getName());
        else {
            System.out.printf("%s %s: \"Привет, %s!\"%n", emoji, getName(), super.getFamily().getRandomPet().getNickname());
        }
    }

    @Override
    public String toString() {
        return toStringFormat("Man");
    }
}
