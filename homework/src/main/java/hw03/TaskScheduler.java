package hw03;

import java.util.Scanner;

public class TaskScheduler {
    private static final String MONDAY = "monday";
    private static final String TUESDAY = "tuesday";
    private static final String WEDNESDAY = "wednesday";
    private static final String THURSDAY = "thursday";
    private static final String FRIDAY = "friday";
    private static final String SATURDAY = "saturday";
    private static final String SUNDAY = "sunday";
    private static final String[][] schedule = new String[7][];

    public static final String EXIT_COMMAND = "exit";
    public static final String UPDATE_COMMAND = "reschedule";



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        schedule[0] = new String[]{MONDAY, "do monday work"};
        schedule[1] = new String[]{TUESDAY, "do tuesday work"};
        schedule[2] = new String[]{WEDNESDAY, "do Wednesday work"};
        schedule[3] = new String[]{THURSDAY, "do Thursday work"};
        schedule[4] = new String[]{FRIDAY, "do Friday work"};
        schedule[5] = new String[]{SATURDAY, "do Saturday work"};
        schedule[6] = new String[]{SUNDAY, "do Sunday work"};

        System.out.println("Possible options");
        System.out.println(" - enter the day of the week to get task");
        System.out.println(" - enter reschedule [ day of the week] to update task");
        System.out.println(" - enter exit to finish");

        while (true){
            System.out.print(": ");
            String userInput = input.nextLine();

            int exit = userInput.trim().compareToIgnoreCase(EXIT_COMMAND);
            if(exit == 0) break;

            if(userInput.toLowerCase().contains(UPDATE_COMMAND)) {
                String day = userInput.replace(UPDATE_COMMAND, " ");
                System.out.println("Please, input new task for " + day.trim());
                String task = input.nextLine();
                updateTaskForDay(day, task);
                continue;
            }

            getTaskForDay(userInput);

        }
    }


    public static void getTaskForDay(String day){
        int dayNumber = getMapDay(day);

        try {
            System.out.println(schedule[dayNumber][1]);
        } catch (Exception e){
            System.out.println("Sorry, I don't understand you, please try again.");
        }
    }

    public static void updateTaskForDay(String day, String newTask){
        int dayNumber = getMapDay(day);

        try {
            schedule[dayNumber][1] = newTask;
        } catch (Exception e){
            System.out.println("Sorry, I don't understand you, please try again.");
        }

    }

    public static int getMapDay(String day){
        day = day.toLowerCase().trim();
        int result;

        switch (day){
            case MONDAY:
                result = 0;
                break;
            case TUESDAY:
                result = 1;
                break;
            case WEDNESDAY:
                result = 2;
                break;
            case THURSDAY:
                result = 3;
                break;
            case FRIDAY:
                result = 4;
                break;
            case SATURDAY:
                result = 5;
                break;
            case SUNDAY:
                result = 6;
                break;
            default:
                result = -1;
                break;
        }

        return result;
    }


}
