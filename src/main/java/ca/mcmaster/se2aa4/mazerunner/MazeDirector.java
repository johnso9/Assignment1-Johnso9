/* Owen Johnson
 * 
 * Puts all the instructions together to build the maze.
 * 
 */
package ca.mcmaster.se2aa4.mazerunner;

public class MazeDirector{
    public Maze buildMaze(int rows, int cols, String filePath){
        return new Maze.Builder()
            .setRowCount(rows)
            .setColumnCount(cols)
            .initializeMaze(filePath)
            .findStartEndPositions()
            .build();
    }
}