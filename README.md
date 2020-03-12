# maze: Intro to Programming

## Project Description
The goal of this game is to get from a point A to a point B through a maze using conditions, loops and functions.
The exercises are meant for participants who are new to programming.
Instructors are free to adapt the included exercises as they wish or to create more levels using the instructions provided below.

## Environment Setup
This game is not meant to be compiled as an executable. 
Instead, you should have a look through the source code and see if you can complete the empty methods required to pass each level.
Most of your work should be in App.java, but feel free to snoop around and play with the rest of the app.

## How to Play
Please see INSTRUCTIONS.md

## Check Your Answers
Please see ANSWERS.md

## Create Your Own Levels
In order to add a new level, you will need to :
1. Create a method *public void levelX()* in App.java. Don't forget the instructions and hints in the comment above!
2. Update *MAX_LEVEL* in Main.java
3. Add a switch case calling app.levelX() in Main.java
4. Initialize a 2D array corresponding to your map *private static int[][] LEVEL_X* in Maze.java
5. Add the initial x and y coordinates in a new switch case in the constructor of Maze.java
