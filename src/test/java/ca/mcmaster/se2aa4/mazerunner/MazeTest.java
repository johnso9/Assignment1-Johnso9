package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class MazeTest {
    
    @Test
    public void testTinyMazeInitialization() {
        Maze maze = new Maze();
        maze.setMazeSize(7, 7);
        maze.initializeMaze("./examples/tiny.maz.txt");
        maze.findStartEndPositions();

        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 5);
        assertEquals(maze.getFinishPosition()[0], 6);
        assertEquals(maze.getFinishPosition()[1], 1);
    }

    @Test
    public void testSmallMazeInitialization() {
        Maze maze = new Maze();
        maze.setMazeSize(11, 11);
        maze.initializeMaze("./examples/small.maz.txt");
        maze.findStartEndPositions();

        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 8);
        assertEquals(maze.getFinishPosition()[0], 10);
        assertEquals(maze.getFinishPosition()[1], 5);
    }

    @Test
    public void testRectangleMazeInitialization() {
        Maze maze = new Maze();
        maze.setMazeSize(21, 51);
        maze.initializeMaze("./examples/rectangle.maz.txt");
        maze.findStartEndPositions();
        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 12);
        assertEquals(maze.getFinishPosition()[0], 50);
        assertEquals(maze.getFinishPosition()[1], 10);
    }

    @Test
    public void testGetCoordinates() {
        Maze maze = new Maze();
        maze.setMazeSize(11, 11);
        maze.initializeMaze("./examples/small.maz.txt");
        maze.findStartEndPositions();
        assertEquals(maze.getCoordinates(8, 0), ' ');
        assertEquals(maze.getCoordinates(9, 0), '#');
    }

    // Add more test cases as needed
}
