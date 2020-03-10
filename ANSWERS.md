# Answers

There could be more than a single valid answer.
The following possible answers are only provided for reference.

### Level 1
    maze.goForward();
    maze.turnLeft();
    maze.goForward();
    maze.turnRight();
    maze.goForward();

### Level 2
    for(int i = 0; i < 6; i++) {
        maze.goForward();
        if (i % 2 == 0) {
            maze.turnLeft();
        } else {
            maze.turnRight();
        }
    }

### Level 3
    while(!maze.reachedGoal()) {
        if (!maze.canGoForward()) {
            maze.turnLeft();
        }
        maze.goForward();
    }

### Level 4
    for (int i = 0; i < 5; i++) {
        while(maze.canGoForward()) {
            maze.goForward();
        }
        maze.turnRight();
    }