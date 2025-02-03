/* Owen Johnson
 * 
 * Extends Runner class to override solveMaze with the user-input path. 
 * Follows user-given instructions, and able to parse canonical or factorized paths.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class InputRunner extends Runner {

    private String userInput;

    public InputRunner(Direction currentDir, int [] coordinates, String userInput){
        super(currentDir, coordinates);
        this.userInput = userInput;

    }

    public String solveMaze(Maze maze){
        int multiplyNext = 1;
        for(int i=0; i<this.userInput.length(); i++){
            char step = this.userInput.charAt(i);
            if(Character.isDigit(step)){
                multiplyNext = Character.getNumericValue(step);
            }else{ 
                for(int j=0; j<multiplyNext; j++){
                    switch(step){
                        case 'F':
                            this.move();
                            System.out.println("moov");
                            if(Arrays.equals(this.coordinates, maze.getFinishPosition())){
                                System.out.println("CORRECT");
                                return ("correct path");
                            }else if(maze.getCoordinates(this.coordinates[1], this.coordinates[0]) == '#'){
                                return ("incorrect path");
                            }
                            break;
                        case 'R':
                            this.turnRight();
                            break;
                        case 'L':
                            this.turnLeft();
                            break;
                    }
                    
                }
                multiplyNext = 1;
            }

        }
        if(Arrays.equals(this.coordinates, maze.getFinishPosition())){
            return ("correct path");
        }else{
            return ("incorrect path");
        }
        
    }
}
