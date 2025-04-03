package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class MazeTest {
    
    @Test
    public void testTinyMazeInitialization() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(7, 7, "./examples/tiny.maz.txt");

        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 5);
        assertEquals(maze.getFinishPosition()[0], 6);
        assertEquals(maze.getFinishPosition()[1], 1);
    }

    @Test
    public void testSmallMazeInitialization() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(11, 11, "./examples/small.maz.txt");
        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 8);
        assertEquals(maze.getFinishPosition()[0], 10);
        assertEquals(maze.getFinishPosition()[1], 5);
    }

    @Test
    public void testRectangleMazeInitialization() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(21, 51, "./examples/rectangle.maz.txt");
        assertEquals(maze.getStartPosition()[0], 0);
        assertEquals(maze.getStartPosition()[1], 12);
        assertEquals(maze.getFinishPosition()[0], 50);
        assertEquals(maze.getFinishPosition()[1], 10);
    }

    @Test
    public void testGetCoordinates() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(11, 11, "./examples/small.maz.txt");
        assertEquals(maze.getCoordinates(8, 0), ' ');
        assertEquals(maze.getCoordinates(9, 0), '#');
    }

}
