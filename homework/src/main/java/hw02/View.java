package hw02;

import java.util.Arrays;

public class View {
    private char[][] battlefield = new char[Controller.SIZE][Controller.SIZE];

    /**
     * Constructor returns instance of battlefield with predefined default values
     */
    public View(){
        for (char[] cell : battlefield) Arrays.fill(cell, '-');
    }

    /**
     * Print battlefield in his actual state
     */
    public void printField() {
        for (char[] row : battlefield) {
            for (char col : row) System.out.print(col + " ");
            System.out.println();
        }
    }

    /**
     * To add checkmark to the battlefield
     * @param pointX    x-coordinate
     * @param pointY    y-coordinate
     * @param result    hit on target or shot off target
     */
    public void setShot(int pointX, int pointY, Boolean result) {
        if(result) {
            this.battlefield[pointY - 1][pointX - 1] = '*';
        } else {
            this.battlefield[pointY - 1][pointX - 1] = 'x';
        }
    }
}
