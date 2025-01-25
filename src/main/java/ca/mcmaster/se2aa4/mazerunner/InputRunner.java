package ca.mcmaster.se2aa4.mazerunner;

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
        boolean valid = true;
        int multiplyNext = 1;
        for(int i=0; i<this.userInput.length(); i++){
            char step = this.userInput.charAt(i);
            if(Character.isDigit(step)){
                multiplyNext = (int)step;
            }else{ 
                for(int j=0; j<multiplyNext; j++){
                switch(step){
                    case 'F':
                        this.move();
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
        return "Valid";
    }
}
