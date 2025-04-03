package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;


public class MainTest {

    @Test
    public void testSmallMazeAlgorithm() {
        Maze maze = new Maze(); 
        maze.initializeMaze(11, 11, "./examples/small.maz.txt");
        maze.findStartEndPositions();
        Runner runner = new RightHandRunner(Runner.Direction.RIGHT, maze.getStartPosition());
        String result = runner.solveMaze(maze);
        assertEquals("F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F ", result);
    }

    @Test
    public void testSmallMazeInput() {
        Maze maze = new Maze(); 
        maze.initializeMaze(11, 11, "./examples/small.maz.txt");
        maze.findStartEndPositions();
        Runner runner = new InputRunner(Runner.Direction.RIGHT, maze.getStartPosition(), "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F ");
        String result = runner.solveMaze(maze);
        assertEquals("correct path", result);
    }

}
