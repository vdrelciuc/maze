/*
 * Formation : introduction a la programmation
 * Exercice : labyrinthe
 * Auteur : Projet PC2 (www.projetpc2.org)
 * Distribué sous license MIT (https://opensource.org/licenses/MIT)
 *
 * RÈGLEMENTS :
 * Vous êtes initialement au point X et souhaitez atteindre le point O.
 * Déplacez-vous en utilisant le moins d'appels possibles à la fonction avancer().
 * Référez-vous aux limites exactes indiquées au-dessus de chaque question, de même qu'aux indices.
 * Privilégiez les boucles, les conditions et les fonctions mises à votre disposition.
 * Notez que X commence toujours orienté vers la droite (->).
 * Lorsque vous réussissez un niveau, passez au suivant en changeant la valeur de NIVEAU_ACTUEL
 * Faites-nous signe si vous bloquez ou si une erreur survient.
 * Amusez-vous !
 *
 * FONCTIONS À VOTRE DISPOSITION :
 * maze.avancer()        Permet d'avancer de 2 cases à la fois
 * maze.tournerGauche()  Permet de tourner à gauche
 * maze.tournerDroite()  Permet de tourner à droite
 * maze.peutContinuer()  Retourne un bouléen qui indique si on peut continuer d'avancer
 * maze.butAtteint()     Retourne un bouléen qui indique si le but (O) est atteint
 */

package org.projetpc2.maze;

class App {

    public Maze maze;
    public int CURRENT_LEVEL = 1; // Vous devez modifier cette valeur à chaque changement de niveau (max: 4)

    App() {
        this.maze = new Maze(CURRENT_LEVEL);
    }

    /*
        ##########
        ##########
        ##########
        #####..O##
        #####.####
        ###X..####
        ##########
        ##########
        ##########
        ##########
        Indications : aucune
        Indice : peut se faire de plusieures manières
      */
    public void niveau1() {
        // Écrivez votre code ici
    }

    /*
      ##########
      ##########
      #######O##
      #######.##
      #####...##
      #####.####
      ###...####
      ###.######
      #X..######
      ##########
      Indications : utilisez au MAXIMUM 1 appel à avancer()
      Indice : le modulo (%) donne le reste d'une division. Ex: 8 % 3 donne 2
    */
    public void niveau2() {
        // Écrivez votre code ici
    }

    /*
      ##########
      ##########
      ##########
      #######O##
      ######..##
      ####.##.##
      ####.##..#
      #X......##
      ######.###
      ##########
      Indications : utilisez au MAXIMUM 1 appel à avancer() et aucune boucle FOR
      Indice : n'oubliez pas les fonctions mises à disposition
    */
    public void niveau3() {
        // Écrivez votre code ici
    }

    /*
      ##########
      ####.#####
      ##X....###
      ####.#.###
      ####....##
      ######.###
      ##..O#.###
      ##.#.#.###
      ##.....###
      ##########
      Indications : utilisez au MAXIMUM 1 appel à avancer()
      Indice : récapitulatif (n.m.) : se dit d'un résumé qui récapitule (Larousse)
    */
    public void niveau4() {
        // Écrivez votre code ici
    }
}
