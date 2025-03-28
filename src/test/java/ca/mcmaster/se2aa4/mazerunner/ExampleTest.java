package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;


public class ExampleTest {

    @Test
    public void sampleTest() {
        assertTrue(1 == 1);
    }

    @Test
    public void testSmallMaze() {
        Maze maze = new Maze(); 
        maze.initializeMaze(11, 11, "./examples/small.maz.txt");
        maze.findStartEndPositions();
        Runner runner = new RightHandRunner(Runner.Direction.RIGHT, maze.getStartPosition());
        System.out.println("Start Position: " + maze.getStartPosition()[0] + ", " + maze.getStartPosition()[1]);
        System.out.println("Finish Position: " + maze.getFinishPosition()[0] + ", " + maze.getFinishPosition()[1]);
        String result = runner.solveMaze(maze);
        assertEquals("F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F ", result);
    }

    


}
