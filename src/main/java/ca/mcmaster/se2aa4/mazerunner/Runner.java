package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public abstract class Runner {
    
    enum Direction{
        RIGHT, LEFT, UP, DOWN;
    }

    protected Direction currentDir;
    protected int[] coordinates = new int[2]; //x,y

    public Runner(Direction currentDir, int [] coordinates){
        this.currentDir = currentDir;
        this.coordinates = coordinates;
    }

    public void turnRight(){
        switch(this.currentDir){
            case Direction.LEFT:
                this.currentDir = Direction.UP;
                break;
            case Direction.RIGHT:
                this.currentDir = Direction.DOWN;
                break;
            case Direction.UP:
                this.currentDir = Direction.RIGHT;
                break;
            case Direction.DOWN:
                this.currentDir = Direction.LEFT;
                break;
        }
    }

    public void turnLeft(){
        switch(this.currentDir){
            case Direction.LEFT:
                this.currentDir = Direction.DOWN;
                break;
            case Direction.RIGHT:
                this.currentDir = Direction.UP;
                break;
            case Direction.UP:
                this.currentDir = Direction.LEFT;
                break;
            case Direction.DOWN:
                this.currentDir = Direction.RIGHT;
                break;
        }
    }

    public void move(){
        switch(this.currentDir){
            case Direction.LEFT:
                this.coordinates[0] -= 1;
                break;
            case Direction.RIGHT:
                this.coordinates[0] += 1;
                break;
            case Direction.UP:
                this.coordinates[1] += 1;
                break;
            case Direction.DOWN:
                this.coordinates[1] -= 1;
                break;
        }
    }

    public abstract String solveMaze(Maze maze);
}
