/* Owen Johnson
 * 
 * Extends BaseStrategy class to inherit movement.
 * Implements the Strategy interface which it then overrides with the user-input path solving method. 
 * Builds a path through using StringBuilder, and returns the completed string.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

public class RightHandRunner extends BaseStrategy implements RunnerStrategy{

    public RightHandRunner(Direction currentDir, int [] coordinates){
        super(currentDir, coordinates);

    }

    public char showBlockAhead(Maze maze, Direction dir){
        char block;
        switch(dir){
            case Direction.LEFT:
                block = maze.getCoordinates(this.coordinates[1], this.coordinates[0]-1);
                break;
            case Direction.RIGHT:
                block = maze.getCoordinates(this.coordinates[1], this.coordinates[0]+1);
                break;
            case Direction.UP:
                block = maze.getCoordinates(this.coordinates[1]-1, this.coordinates[0]);
                break;
            case Direction.DOWN:
                block = maze.getCoordinates(this.coordinates[1]+1, this.coordinates[0]);
                break;
            default:
                block = '#';
                break;
        }
        return block;
    }

    public char showBlockRight(Maze maze, Direction dir){
        char block;
        switch(dir){
            case Direction.LEFT:
                block = maze.getCoordinates(this.coordinates[1]-1, this.coordinates[0]);
                break;
            case Direction.RIGHT:
                block = maze.getCoordinates(this.coordinates[1]+1, this.coordinates[0]);
                break;
            case Direction.UP:
                block = maze.getCoordinates(this.coordinates[1], this.coordinates[0]+1);
                break;
            case Direction.DOWN:
                block = maze.getCoordinates(this.coordinates[1], this.coordinates[0]-1);
                break;
            default:
                block = '#';
                break;
        }
        return block;
    }

    public String solveMaze(Maze maze){
        StringBuilder path = new StringBuilder();
        char prevDirection = 'F';
        int consecutiveDirections = 0;
        while(!Arrays.equals(this.coordinates, maze.getFinishPosition())){
            if(showBlockRight(maze, currentDir) == ' '){
                turnRight();
                move();
                //path.append("RF");
                if(prevDirection == 'R'){
                    consecutiveDirections += 1;
                }else{
                    if(consecutiveDirections > 1){
                        path.append(consecutiveDirections + (prevDirection + " "));
                    }else{
                        path.append(prevDirection + " ");
                    }
                    consecutiveDirections = 1;
                }
                path.append("R ");
                consecutiveDirections = 1;
                prevDirection = 'F';
            }else if(showBlockAhead(maze, currentDir) == ' '){
                move();
                //path.append("F");
                if(prevDirection == 'F'){
                    consecutiveDirections += 1;
                }else{
                    if(consecutiveDirections > 1){
                        path.append(consecutiveDirections + (prevDirection + " "));
                    }else{
                        path.append(prevDirection + " ");
                    }
                    consecutiveDirections = 1;
                }
                prevDirection = 'F';
            }else{
                turnLeft();
                //path.append("L ");
                if(prevDirection == 'L'){
                    consecutiveDirections += 1;
                }else{
                    if(consecutiveDirections > 1){
                        path.append(consecutiveDirections + (prevDirection + " "));
                    }else{
                        path.append(prevDirection + " ");
                    }
                    consecutiveDirections = 1;
                }
                prevDirection = 'L';
            }
        }
        if(consecutiveDirections > 1){
            path.append(consecutiveDirections + (prevDirection + " "));
        }else{
            path.append(prevDirection + " ");
        }
        return (path.toString());
    }
}
