package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class DirectionTest {
    
    @Test
    public void testToRight() {
        Direction d = Direction.UP;
        Direction dRight = d.toRight();
        assertTrue(dRight == Direction.RIGHT);
    }

    @Test
    public void testToLeft() {
        Direction d = Direction.UP;
        Direction dLeft = d.toLeft();
        assertTrue(dLeft == Direction.LEFT);
    }


}
