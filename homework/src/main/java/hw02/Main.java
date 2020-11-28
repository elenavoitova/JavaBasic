package hw02;

import java.util.Scanner;

public class Main {
    private static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        Controller.generateShip();
        View gameField = new View();
        System.out.println("All set. Get ready to rumble!");

        while (!Controller.stop){
            int x = getValidUserInput("Enter X: ");
            int y = getValidUserInput("Enter Y: ");

            gameField.setShot(x, y, Controller.checkShot(x, y));
            gameField.printField();
        };


    }

    /**
     * Loop for getting valid user input
     * @param message - info message about what are you waiting from user
     * @return
     */
    public static int getValidUserInput(String message) {
        System.out.println(message);
        while(true){
            int value = validateInput(input.next());
            if (value >= 0) return value;
        }
    };

    /**
     * Validate users input to be not out of battlefield range
     * @param value - value that should be validated
     * @return - negative number in case of failed validation or positive value in case of passed validation
     */
    public static int validateInput(String value) {
        String outOfRangeMessage = "Enter an integer value in range 1 - " + Controller.SIZE;
        int result = -1;
            try {
                int resultInt = Integer.parseInt(value);
                if (resultInt >= 1 && resultInt <= Controller.SIZE) {
                    result = resultInt;
                } else {
                    System.out.println(outOfRangeMessage);
                }
            } catch (Exception e) {
                System.out.println("Your input isn't valid. " + outOfRangeMessage);
            };

        return result;
    }
}
