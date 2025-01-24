package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class InputRunner extends Runner {
    

    public InputRunner(Direction currentDir, int [] coordinates){
        super(currentDir, coordinates);
    }

    public String solveMaze(Maze maze){
        return "Solving maze...";
    }
}
