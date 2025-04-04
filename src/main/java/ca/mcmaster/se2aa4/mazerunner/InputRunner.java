/* Owen Johnson
 * 
 * Extends BaseStrategy class to inherit movement.
 * Implements the Strategy interface which it then overrides with the user-input path solving method. 
 * Follows user-given instructions, and able to parse canonical or factorized paths.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;


public class InputRunner extends BaseStrategy implements RunnerStrategy{

    private String userInput;

    public InputRunner(Direction currentDir, int [] coordinates, String userInput){
        super(currentDir, coordinates);
        this.userInput = userInput;

    }

    public String solveMaze(Maze maze){
        int multiplyNext = 1;
        int digitsInARow = 0;
        for(int i=0; i<this.userInput.length(); i++){
            char step = this.userInput.charAt(i);
            if(Character.isDigit(step)){
                digitsInARow += 1;
                if(digitsInARow > 1){
                    multiplyNext = multiplyNext * 10 + Character.getNumericValue(step);
                }else{
                    multiplyNext = Character.getNumericValue(step);
                }
                
            }else{ 
                digitsInARow = 0;
                for(int j=0; j<multiplyNext; j++){
                    switch(step){
                        case 'F':
                            this.move();
                            if(Arrays.equals(this.coordinates, maze.getFinishPosition())){
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
