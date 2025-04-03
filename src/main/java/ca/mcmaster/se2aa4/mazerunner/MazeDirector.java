package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeDirector{
    public Maze buildMaze(int rows, int cols, String filePath){
        return new Maze.Builder()
            .setRowCount(rows)
            .setColumnCount(cols)
            .initializeMaze(filePath)
            .findStartEndPositions()
            .build();
    }
}