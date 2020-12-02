package hw02;

import java.util.Arrays;
import java.util.Random;

public class Controller {
    public static final int SIZE = 5;
    private final static int[][] shipOnField = new int[SIZE][SIZE];
    private static int[][] madeShots = new int [SIZE * SIZE][];
    public static boolean stop = false;
    private static int positiveShotsCounter;
    private static int shotsCounter;

    /**
     * Generate 3-points ship randomly horizontally or vertically
     * Fill it with 1 number
     */
    public void generateShip(){
        Random random = new Random();
        boolean direction = random.nextBoolean();
        int point1 = random.nextInt(SIZE - 1);
        int point2 = random.nextInt(SIZE - 2) + 1;

        this.locateShip(point1, point2, direction);

    }

    private void locateShip(int p1, int p2, boolean isVertical) {
        if (isVertical) {
            shipOnField[p2][p1] = 1;
            shipOnField[p2 - 1][p1] = 1;
            shipOnField[p2 + 1][p1] = 1;
        } else {
            shipOnField[p1][p2] = 1;
            shipOnField[p1][p2 - 1] = 1;
            shipOnField[p1][p2 + 1] = 1;
        }
    }




    /**
     * Flag for the game end
     * @param positiveShotsCounter - number of successful tries
     * @return true if game end or false if game continue
     */
    private static boolean triggerStop(int positiveShotsCounter){
        if(positiveShotsCounter == 3) {
            stop = true;
            System.out.println("You have won!");
        }
        return stop;
    }

    /**
     * Check 0 or 1 keeps in checked point
     * @param x - x-coordinate
     * @param y - y-coordinate
     * @return - true if 1 keeps in checked point of false if 0
     */
    public static boolean checkShot (int x, int y){
        boolean compareResult = false;

        madeShots[shotsCounter++] = new int[]{x, y};

        if(shipOnField[x - 1][y - 1] == 1) {
            compareResult = true;
            positiveShotsCounter++;
        }
        triggerStop(positiveShotsCounter);

        return compareResult;
    }


}
