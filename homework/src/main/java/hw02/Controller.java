package hw02;

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
    public static void generateShip(){
        int vertical = 0;
        int horizontal = 1;
        Random random = new Random();

        int direction = random.nextInt(2);
        if(direction == horizontal){
            int pointX = random.nextInt(SIZE - 1);
            int middlePointY = random.nextInt(SIZE - 2) + 1;
            for (int i = 0; i < SIZE; i++) {
                if(i != pointX) continue;
                for (int j = middlePointY - 1; j <= middlePointY + 1; j++) {
                    shipOnField[i][j] = 1;
                }
            }
        }
        if (direction == vertical) {
            int pointY = random.nextInt(SIZE - 1);
            int middlePointX = random.nextInt(SIZE - 2) + 1;
            for (int i = middlePointX - 1; i <= middlePointX + 1; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(j != pointY) continue;
                    shipOnField[i][j] = 1;
                }
            }
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
