package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class MazeTest {
    
    @Test
    public void testSmallMazeInitialization() {
        Maze maze = new Maze();
        maze.initializeMaze(11, 11, "./examples/small.maz.txt");
        maze.findStartEndPositions();

        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 8);
        assertEquals(maze.getFinishPosition()[0], 10);
        assertEquals(maze.getFinishPosition()[1], 5);
    }

    @Test
    public void testRectangleMazeInitialization() {
        Maze maze = new Maze();
        maze.initializeMaze(21, 51, "./examples/rectangle.maz.txt");
        maze.findStartEndPositions();
        System.out.println(maze.getStartPosition()[0]);
        System.out.println(maze.getStartPosition()[1]);
        System.out.println(maze.getFinishPosition()[0]);
        System.out.println(maze.getFinishPosition()[1]);
        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 12);
        assertEquals(maze.getFinishPosition()[0], 50);
        assertEquals(maze.getFinishPosition()[1], 10);
    }

    // Add more test cases as needed
}
