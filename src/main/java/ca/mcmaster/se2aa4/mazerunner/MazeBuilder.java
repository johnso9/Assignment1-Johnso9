package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeBuilder {
    private static final Logger logger = LogManager.getLogger();

    private char[][] maze;
    private int[] startPos = new int[2];
    private int[] finishPos = new int[2];
    private int rows;
    private int cols;

    public MazeBuilder setMazeSize(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        return this;
    }

    public MazeBuilder initializeMaze(String filePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            
            char[][] contents = new char[this.rows][this.cols];

            for (int i = 0; i < this.rows; i++) {
                if((line = reader.readLine()) != null){
                    for (int j = 0; j < this.cols; j++) {
                        if (line.charAt(j) == '#') {
                            contents[i][j] = '#';
                        } else if (line.charAt(j) == ' ') {
                            contents[i][j] = ' ';
                        }
                    }
                }
            }
            this.maze = contents;
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\"); 
        }
        return this;
    }

    public MazeBuilder findStartEndPositions(){
        int[] leftPos = new int[2];
        int[] rightPos = new int[2];

        for(int i=0; i<this.rows-1; i++){
            if(maze[i][0] == ' '){
                leftPos[0] = 0; //x
                leftPos[1] = i; //y
            }
            if(maze[i][this.cols-1] == ' '){
                rightPos[0] = maze[0].length-1; //x
                rightPos[1] = i; //y
            }
        }
        this.startPos = leftPos;
        this.finishPos = rightPos;
        return this;
    }

    // public Maze build(){
    //     return new Maze(this);
    // }
}
