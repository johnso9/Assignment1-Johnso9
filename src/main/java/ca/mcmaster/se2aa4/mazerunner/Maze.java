/* Owen Johnson
 *
 * Defines Maze object structure, with capability to: 
 * - create a 2d array of chars from a filepath to initialize the maze
 * - get the contents of any maze coordinate needed
 * - initializing start/end positions of the given maze
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {

    private static final Logger logger = LogManager.getLogger();

    private char[][] maze;
    private int[] startPos = new int[2];
    private int[] finishPos = new int[2];
    private int rows;
    private int cols;


    public void initializeMaze(int rows, int cols, String filePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            
            this.rows = rows;
            this.cols = cols;
            char[][] contents = new char[rows][cols];


            for (int i = 0; i < rows; i++) {
                if((line = reader.readLine()) != null){
                    for (int j = 0; j < cols; j++) {
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
    }

    public void findStartEndPositions(){
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
    }

    public int[] getStartPosition(){
        return this.startPos;
    }
    
    public int[] getFinishPosition(){
        return this.finishPos;
    }

    public char getCoordinates(int row, int col){
        return this.maze[row][col];
    }
}
