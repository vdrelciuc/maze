package org.projetpc2.maze;

/***
 * Formation : introduction a la programmation
 * Exercice : labyrinthe
 * Auteur : Projet PC2 (www.projetpc2.org)
 * Distribué sous license MIT (https://opensource.org/licenses/MIT)
 **/

public class Maze {

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    private boolean isOver = false;
    private boolean isSuccessful = false;
    private int[][] maze;
    private int i = 0;
    private int j = 0;
    private final int STEP = 2;
    private Direction direction = Direction.RIGHT;

    // use symbols to make reading the output easier...
    // 0 - obstacle - '#'
    // 1 - open space - '.'
    // 2 - path taken - 'X'
    // 3 - goal - 'O'
    private char[] mazeSymbols = {'#', '.', 'X', 'O' };

    // 0 - obstacle
    // 1 - open space
    // 2 - path taken
    // 3 - goal
    private static int[][] LEVEL_ONE =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 1, 3, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 2, 1, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

    private static int[][] LEVEL_TWO =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 2, 1, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

    private static int[][] LEVEL_THREE =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
                    {0, 2, 1, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

    private static int[][] LEVEL_FOUR =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 2, 1, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 1, 1, 3, 0, 1, 0, 0, 0},
                    {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

    public Maze(int niveau){
        switch(niveau) {
            case 1:
                this.maze = LEVEL_ONE;
                i = 5;
                j = 3;
                break;
            case 2:
                this.maze = LEVEL_TWO;
                i = 8;
                j = 1;
                break;
            case 3:
                this.maze = LEVEL_THREE;
                i = 7;
                j = 1;
                break;
            case 4:
                this.maze = LEVEL_FOUR;
                i = 2;
                j = 2;
                break;
        }
    }

    public void avancer() {
        for (int k = 0; k < STEP; k++) {
            if (!isOver) {
                switch(direction) {
                    case LEFT:
                        if(isAvailablePosition(i, j - 1)) { // aimed position is valid
                            j--;
                            if (maze[i][j] == 3) { // aimed position is end, finish game
                                isOver = true;
                                isSuccessful = true;
                            }
                            // aimed position is not end, mark as visited
                            maze[i][j] = 2;
                        } else { // aimed position is invalid
                            isOver = true;
                            isSuccessful = false;
                        }
                        break;
                    case RIGHT:
                        if(isAvailablePosition(i, j + 1)) { // aimed position is valid
                            j++;
                            if (maze[i][j] == 3) { // aimed position is end, finish game
                                isOver = true;
                                isSuccessful = true;
                            }
                            // aimed position is not end, mark as visited
                            maze[i][j] = 2;
                        } else { // aimed position is invalid
                            isOver = true;
                            isSuccessful = false;
                        }
                        break;
                    case UP:
                        if(isAvailablePosition(i - 1, j)) { // aimed position is valid
                            i--;
                            if (maze[i][j] == 3) { // aimed position is end, finish game
                                isOver = true;
                                isSuccessful = true;
                            }
                            // aimed position is not end, mark as visited
                            maze[i][j] = 2;
                        } else { // aimed position is invalid
                            isOver = true;
                            isSuccessful = false;
                        }
                        break;
                    case DOWN:
                        if(isAvailablePosition(i + 1, j)) { // aimed position is valid
                            i++;
                            if (maze[i][j] == 3) { // aimed position is end, finish game
                                isOver = true;
                                isSuccessful = true;
                            }
                            // aimed position is not end, mark as visited
                            maze[i][j] = 2;
                        } else { // aimed position is invalid
                            isOver = true;
                            isSuccessful = false;
                        }
                        break;
                }
                print();
            }

        }
    }

    public void tournerGauche() {
        if (!isOver) {
            switch(direction) {
                case LEFT:
                    direction = Direction.DOWN;
                    break;
                case RIGHT:
                    direction = Direction.UP;
                    break;
                case UP:
                    direction = Direction.LEFT;
                    break;
                case DOWN:
                    direction = Direction.RIGHT;
                    break;
            }
        }
    }

    public void tournerDroite() {
        if (!isOver) {
            switch(direction) {
                case LEFT:
                    direction = Direction.UP;
                    break;
                case RIGHT:
                    direction = Direction.DOWN;
                    break;
                case UP:
                    direction = Direction.RIGHT;
                    break;
                case DOWN:
                    direction = Direction.LEFT;
                    break;
            }
        }
    }

    public boolean peutContinuer() {
        if (!isOver) {
            switch(direction) {
                case LEFT:
                    return isAvailablePosition(i, j - STEP);
                case RIGHT:
                    return isAvailablePosition(i, j + STEP);
                case UP:
                    return isAvailablePosition(i - STEP, j);
                case DOWN:
                    return isAvailablePosition(i + STEP, j);
            }
        }
        return false;
    }

    public boolean butAtteint() {
        return isSuccessful;
    }

    private boolean isAvailablePosition(int row, int col) {
        boolean result =  row >= 0 && row < maze.length
                && col >= 0 && col < maze[row].length
                && (maze[row][col] == 1 || maze[row][col] == 3);
        return result;
    }

    public void print(){
        System.out.println();
        for(int row = 0; row < maze.length; ++row) {
            for(int col = 0; col < maze[row].length; ++col) {
                System.out.print(mazeSymbols[maze[row][col]]);
            }
            System.out.println();
        }
    }

    public boolean getIsOver() {
        return isOver;
    }

    public boolean getIsSuccessful() {
        return isSuccessful;
    }

}