/* Owen Johnson
 * 
 * Abstract class that defines the 4 possible movement 
 * directions, as well as turning left/right and moving 
 * forward (corresponding to the current direction).
 * 
 */
package ca.mcmaster.se2aa4.mazerunner;

public abstract class BaseStrategy{
    protected Direction currentDir;
    protected int[] coordinates = new int[2]; //x,y

    public BaseStrategy(Direction currentDir, int [] coordinates){
        this.currentDir = currentDir;
        this.coordinates = coordinates;
    }

    public void turnRight(){
        this.currentDir = currentDir.toRight();
    }

    public void turnLeft(){
        this.currentDir = currentDir.toLeft();
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
                this.coordinates[1] -= 1;
                break;
            case Direction.DOWN:
                this.coordinates[1] += 1;
                break;
        }
        if(this.coordinates[0] < 0){
            this.coordinates[0] = 0; // cannot exit through start of maze, will reset back to left x coordinate if you try to go to, for exmaple, an x coordinate of -1
        }
    }
}
