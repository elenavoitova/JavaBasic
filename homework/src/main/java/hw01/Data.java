package hw01;

import java.util.Random;

public class Data{
    static final private String QUESTION_1 =  "Когда был изобретен первый конструктор";
    static final private String ANSWER_1 = "1957";

    static final private String QUESTION_2 = "Когда был изобретен первый самолет";
    static final private String ANSWER_2 = "1890";

    static final private String QUESTION_3 = "Когда был изобретен рентген";
    static final private String ANSWER_3 = "1895";

    static final private String QUESTION_4 = "Когда был изобретен общий наркоз";
    static final private String ANSWER_4 = "1804";

    static final private String QUESTION_5 = "Когда был изобретен холодильник";
    static final private String ANSWER_5 = "1755";

    static private int goal;

    /**
     * Randomly choose pair Question-Answer
     * @return - chosen Question
     */
    public static String generate(){
        String[][] data = new String[5][];
        data[0] = new String[]{QUESTION_1, ANSWER_1};
        data[1] = new String[]{QUESTION_2, ANSWER_2};
        data[2] = new String[]{QUESTION_3, ANSWER_3};
        data[3] = new String[]{QUESTION_4, ANSWER_4};
        data[4] = new String[]{QUESTION_5, ANSWER_5};

        Random random = new Random();
        int randValue = random.nextInt(5);

        goal = Integer.parseInt(data[randValue][1]);

        return data[randValue][0];
    }

    public static int checkResult(int value){
        return goal - value;
    }

}
