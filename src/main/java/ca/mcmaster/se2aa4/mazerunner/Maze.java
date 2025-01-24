package ca.mcmaster.se2aa4.mazerunner;


public class Maze {
    private char[][] maze;
    private int[] startPos = new int[2];
    private int[] finishPos = new int[2];
    
    public Maze(char[][] maze){
        this.maze = maze;
    }

    public void findStartEndPositions(){
        int[] leftPos = new int[2];
        int[] rightPos = new int[2];
        for(int i=0; i>maze.length; i++){
            if(maze[i][0] == ' '){
                leftPos[0] = 0; //x
                leftPos[1] = i; //y
            }
            if(maze[i][maze[0].length-1] == ' '){
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
}
