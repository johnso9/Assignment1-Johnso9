package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;


public class MainTest {

    @Test
    public void testSmallMazeAlgorithm() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(11, 11, "./examples/small.maz.txt");
        Runner runner = new RightHandRunner(Direction.RIGHT, maze.getStartPosition());
        String result = runner.solveMaze(maze);
        assertEquals("F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F ", result);
    }

    @Test
    public void testSmallMazeInput() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(11, 11, "./examples/small.maz.txt");
        Runner runner = new InputRunner(Direction.RIGHT, maze.getStartPosition(), "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F ");
        String result = runner.solveMaze(maze);
        assertEquals("correct path", result);
    }

    @Test
    public void testSmallMazeWrongInput() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(11, 11, "./examples/small.maz.txt");
        Runner runner = new InputRunner(Direction.RIGHT, maze.getStartPosition(), "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F 10L 2F");
        String result = runner.solveMaze(maze);
        assertEquals("incorrect path", result);
    }

    @Test
    public void testRectangleMazeAlgorithm() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(21, 51, "./examples/rectangle.maz.txt");
        Runner runner = new RightHandRunner(Direction.RIGHT, maze.getStartPosition());
        String result = runner.solveMaze(maze);
        assertEquals("F R 7F L 4F 2L 4F R 2F R 2F 2L 2F R 16F R 2F R 14F 2L 4F R 2F R 6F 2L 4F R 2F R 6F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 2F L 2F R 2F R 4F R 2F L 2F R 2F 2L 2F R 2F R 2F 2L 2F L 4F R 2F L 8F R 2F 2L 2F R 6F R 2F R 2F 2L 4F R 6F R 2F R 4F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F L 4F R 2F R 6F R 4F 2L 4F R 2F R 6F L 2F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 4F 2L 4F R 2F R 10F R 2F 2L 6F 2L 4F R 8F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 4F L 6F 2L 6F R 2F R 4F 2L 4F R 2F R 4F 2L 6F R 2F R 4F 2L 6F R 2F R 2F 2L 4F R 2F R 2F L 2F R 2F R 2F L 2F R 2F 2L 2F L 2F R 2F L 2F L 2F R 2F R 2F 2L 2F R 6F R 4F R 2F R 2F L 2F 2L 2F R 2F L 2F L 2F R 2F 2L 2F R 2F R 6F R 4F R 2F R 2F 2L 2F L 4F R 2F R 4F L 2F R 2F R 4F 2L 2F R 4F 2L 4F R 2F R 6F R 4F 2L 4F R 2F R 4F L 6F R 2F L 2F R 4F 2L 4F R 2F R 6F 2L 2F R 2F R 6F 2L 2F R 2F R 4F 2L 2F R 2F R 2F 2L 2F L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 8F R 2F 2L 2F L 6F R 2F R 6F L 2F 2L 2F R 2F R 2F 2L 2F R 2F R 2F 2L 2F R 2F L 2F R 2F R 2F 2L 2F R 2F R 4F R 4F 2L 3F R F ", result);
    }

    @Test
    public void testRectangleMazeInput() {
        MazeDirector director = new MazeDirector();
        Maze maze = director.buildMaze(21, 51, "./examples/rectangle.maz.txt");
        Runner runner = new InputRunner(Direction.RIGHT, maze.getStartPosition(), "F R 7F L 4F 2L 4F R 2F R 2F 2L 2F R 16F R 2F R 14F 2L 4F R 2F R 6F 2L 4F R 2F R 6F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 2F L 2F R 2F R 4F R 2F L 2F R 2F 2L 2F R 2F R 2F 2L 2F L 4F R 2F L 8F R 2F 2L 2F R 6F R 2F R 2F 2L 4F R 6F R 2F R 4F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F L 4F R 2F R 6F R 4F 2L 4F R 2F R 6F L 2F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 4F 2L 4F R 2F R 10F R 2F 2L 6F 2L 4F R 8F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 4F L 6F 2L 6F R 2F R 4F 2L 4F R 2F R 4F 2L 6F R 2F R 4F 2L 6F R 2F R 2F 2L 4F R 2F R 2F L 2F R 2F R 2F L 2F R 2F 2L 2F L 2F R 2F L 2F L 2F R 2F R 2F 2L 2F R 6F R 4F R 2F R 2F L 2F 2L 2F R 2F L 2F L 2F R 2F 2L 2F R 2F R 6F R 4F R 2F R 2F 2L 2F L 4F R 2F R 4F L 2F R 2F R 4F 2L 2F R 4F 2L 4F R 2F R 6F R 4F 2L 4F R 2F R 4F L 6F R 2F L 2F R 4F 2L 4F R 2F R 6F 2L 2F R 2F R 6F 2L 2F R 2F R 4F 2L 2F R 2F R 2F 2L 2F L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 8F R 2F 2L 2F L 6F R 2F R 6F L 2F 2L 2F R 2F R 2F 2L 2F R 2F R 2F 2L 2F R 2F L 2F R 2F R 2F 2L 2F R 2F R 4F R 4F 2L 3F R F ");
        String result = runner.solveMaze(maze);
        assertEquals("correct path", result);
    }

}
