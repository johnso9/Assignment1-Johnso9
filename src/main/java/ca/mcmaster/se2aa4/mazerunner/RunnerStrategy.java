/* Owen Johnson
 * 
 * An Interface with SolveMaze method to be overwritten with whatever 
 * method an implementation may have to solve the maze 
 * 
 */
package ca.mcmaster.se2aa4.mazerunner;


public interface RunnerStrategy{
    public String solveMaze(Maze maze);
}
