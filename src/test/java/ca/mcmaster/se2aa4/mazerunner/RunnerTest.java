package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class RunnerTest {
    
    @Test
    public void testTurn() {
        int[] coords = {0,6};
        Runner runner = new InputRunner(Direction.RIGHT, coords, "");
        runner.turnLeft();
        assertEquals(runner.currentDir, Direction.UP);
        runner.turnRight();
        runner.turnRight();
        assertEquals(runner.currentDir, Direction.DOWN);
    }

    @Test
    public void testMove() {
        int[] coords = {0,6};
        Runner runner = new InputRunner(Direction.RIGHT, coords, "");
        runner.move();
        runner.turnRight();
        runner.move();
        runner.move();
        assertEquals(runner.coordinates[0], 1);
        assertEquals(runner.coordinates[1], 8);
    }


}
