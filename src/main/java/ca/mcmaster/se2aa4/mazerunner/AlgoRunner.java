package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class AlgoRunner extends Runner {

    public AlgoRunner(Direction currentDir, int [] coordinates){
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

        while(!Arrays.equals(this.coordinates, maze.getFinishPosition())){
            if(showBlockRight(maze, currentDir) == ' '){
                turnRight();
                move();
                path.append("R F ");
            }else if(showBlockAhead(maze, currentDir) == ' '){
                move();
                path.append("F ");
            }else{
                turnLeft();
                path.append("L ");
            }
        }

        return ("Path to solve maze: " + path.toString());
    }
}
