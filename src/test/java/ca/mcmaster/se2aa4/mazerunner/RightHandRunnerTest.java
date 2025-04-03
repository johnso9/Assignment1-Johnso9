package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class RightHandRunnerTest {
    
    @Test
    public void testShowBlockAhead() {
        Maze maze = new Maze(); 
        maze.setMazeSize(11, 11);
        maze.initializeMaze("./examples/small.maz.txt");
        int[] coords = {9,1};
        RightHandRunner runner = new RightHandRunner(Direction.DOWN, coords);
        char block = runner.showBlockAhead(maze, runner.currentDir);
        assertEquals(block, '#');
    }

    @Test
    public void testShowBlockRight() {
        Maze maze = new Maze();
        maze.setMazeSize(11, 11);
        maze.initializeMaze("./examples/small.maz.txt");
        int[] coords = {9,1};
        RightHandRunner runner = new RightHandRunner(Direction.DOWN, coords);
        char block = runner.showBlockRight(maze, runner.currentDir);
        assertEquals(block, ' ');
    }
}
