/* Owen Johnson
 * 
 * Contains the current strategy for solving the maze.
 * Sets and executes the strategy.
 * 
 */

package ca.mcmaster.se2aa4.mazerunner;

public class Context {
    private RunnerStrategy strategy;

    public String executeStrategy(Maze maze) {
        return strategy.solveMaze(maze);
    }
    public void setStrategy(RunnerStrategy strategy) {
        this.strategy = strategy;
    }

    public RunnerStrategy getStrategy() {
        return this.strategy;
    }
}
