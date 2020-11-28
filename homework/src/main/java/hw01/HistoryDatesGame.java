package hw01;

import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class HistoryDatesGame {
    private final static int MAX_SCORE = 1000;
    static int progress = 0;
    static StringBuilder answers = new StringBuilder();
    static int currentYear = Year.now().getValue();


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = null;

        do {
            System.out.println("Enter your name");
            name = input.nextLine();
        } while (name.length() == 0 || name.equals(" "));
        System.out.println("*******************");
        System.out.println();
        System.out.println("Let the game begin " + name + " !");
        System.out.println();
        System.out.println("*******************");

        String question = Data.generate();
        System.out.println(question);
        while (true) {
            System.out.println("Try №" + (progress + 1));
            String userValue = input.next();

            int validatedValue = validateInput(userValue);

            if (validatedValue < 0) continue;

            int comparatorResult = Data.checkResult(validatedValue);
            if (comparatorResult == 0) {
                System.out.println("Congratulations, " + name + "!");
                System.out.println("Your score is: " + "\u001B[31m" + (MAX_SCORE - progress) + "\u001B[0m");
                System.out.println("Your previous variants are: " + Arrays.toString(sort(answers)));
                break;
            } else {
                progress++;
                answers.append(userValue);
                answers.append(" ");
                if (comparatorResult > 0) {
                    System.out.println("Your number is too small. Please, try again.");
                } else {
                    System.out.println("Your number is too big. Please, try again.");
                }
            }

            System.out.println();
        }

    }

    /**
     * Validate users input to be not out of battlefield range
     * Validation rules: only numbers from 0 to current year
     * @param value - value that should be validated
     * @return - negative number in case of failed validation or positive value in case of passed validation
     */
    public static int validateInput(String value) {
        int result = -1;
        try {
            int resultInt = Integer.parseInt(value);
            if (resultInt > 0 && resultInt <= currentYear) {
                result = resultInt;
            } else {
                System.out.println("Enter a valid year");
            }
        } catch (Exception e) {
            System.out.println("Your input isn't valid");
        };

        return result;
    }

    public static int[] sort(int[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {

                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        return arr;
    };

    public static int[] sort(StringBuilder str) {
        int[] result = parseBy(str, "\\s+");

        return sort(result);
    };

    /**
     * Parse string by separator
     * @param str
     * @param separator
     * @return - empty array or int array
     */
    public static int[] parseBy(StringBuilder str, String separator){
        if(str.length() == 0) return new int[0];
        String[] split = str.toString().split(separator);
        int[] result = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }

        return result;
    }
}
