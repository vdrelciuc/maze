/**
 * @author : Vlad Drelciuc
 */

package org.projetpc2.maze;

import java.util.Scanner;

public class Main {

    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 4;
    private static final int CURRENT_STEP = 2;

    public static void main(String[] args) {

        int selectedLevel;

        do {
            System.out.print("Please enter a level between " + MIN_LEVEL + " and " + MAX_LEVEL + ": ");
            Scanner sc = new Scanner(System.in);
            selectedLevel = sc.nextInt();
        } while (selectedLevel < MIN_LEVEL || selectedLevel > MAX_LEVEL);

        App app = new App(selectedLevel);
        app.maze.setStep(CURRENT_STEP);

        System.out.println("\nSelected level: " + selectedLevel);
        System.out.println("\nInitial maze:");
        app.maze.print();

        switch (selectedLevel) {
            case 1:
                app.level1();
                break;
            case 2:
                app.level2();
                break;
            case 3:
                app.level3();
                break;
            case 4:
                app.level4();
                break;
        }

        System.out.println("\nFinal maze:");
        app.maze.print();

        if (app.maze.getIsSuccessful()) {
            System.out.println("\nCongratulations!");
        } else {
            System.out.println("\nTry again!");
        }


    }
}