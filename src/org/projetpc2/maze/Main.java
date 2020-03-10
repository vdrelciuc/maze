/***
 * Formation : introduction a la programmation
 * Exercice : labyrinthe
 * Auteur : Projet PC2 (www.projetpc2.org)
 * Distribué sous license MIT (https://opensource.org/licenses/MIT)
 **/

package org.projetpc2.maze;

import java.util.Scanner;

public class Main {

    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 4;

    public static void main(String[] args) {

        int selectedLevel;

        System.out.print("Please enter a level between " + MIN_LEVEL + " and " + MAX_LEVEL + ": ");
        Scanner sc = new Scanner(System.in);
        selectedLevel = sc.nextInt();

        App app = new App();

        if (app.CURRENT_LEVEL >= MIN_LEVEL || app.CURRENT_LEVEL <= MAX_LEVEL) {
            System.out.println("Selected level: " + selectedLevel);

            System.out.println("\nLabyrinthe initial");
            app.maze.print();

            switch (selectedLevel) {
                case 1:
                    app.niveau1();
                    break;
                case 2:
                    app.niveau2();
                    break;
                case 3:
                    app.niveau3();
                    break;
                case 4:
                    app.niveau4();
                    break;
            }

            System.out.println("\nLabyrinthe final");
            app.maze.print();

            if (app.maze.getIsSuccessful()) {
                System.out.println("\nFélicitations! Niveau réussi avec succès.");
            } else {
                System.out.println("Niveau échoué. Réessaie!");
            }
        } else {
            System.out.println("Une erreur est survenue. Choisis un niveau entre 1 et 4.");
        }


    }
}