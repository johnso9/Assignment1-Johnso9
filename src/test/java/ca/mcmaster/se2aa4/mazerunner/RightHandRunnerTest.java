package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class RightHandRunnerTest {
    
    @Test
    public void testShowBlockAhead() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(11, 11, "./examples/small.maz.txt");
        int[] coords = {9,1};
        RightHandRunner runner = new RightHandRunner(Direction.DOWN, coords);
        char block = runner.showBlockAhead(maze, runner.currentDir);
        assertEquals(block, '#');
    }

    @Test
    public void testShowBlockRight() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(11, 11, "./examples/small.maz.txt");
        int[] coords = {9,1};
        RightHandRunner runner = new RightHandRunner(Direction.DOWN, coords);
        char block = runner.showBlockRight(maze, runner.currentDir);
        assertEquals(block, ' ');
    }
}
