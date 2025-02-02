/* Owen Johnson
 * 
 * Main input flag logic parser, plus initialization of 
 * needed maze and runner objects depending on given flags.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    

    public static void main(String[] args) {
        Options options = new Options();
        String instructions = "";
        boolean hasInstructions = false;
        Option mazeFile = new Option("i", "input", true, "input maze filepath");
        Option path = new Option("p", "input", true, "input maze path for testing");
        options.addOption(mazeFile);
        options.addOption(path);
        CommandLine cmd;
        CommandLineParser parser = new BasicParser();
        int rows = 0;
        int cols = 0;
        String filePath = "";
        logger.info("** Starting Maze Runner");
        try {
            cmd = parser.parse(options, args);
            if(cmd.hasOption("i")) {
                filePath = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + filePath);
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    cols = line.length();
                    StringBuilder mazeConstruction = new StringBuilder();
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            mazeConstruction.append("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            mazeConstruction.append("PASS ");
                        }
                    }
                    logger.info(mazeConstruction.toString());
                    rows++;
                }
                logger.info(rows + " rows, " + cols + " columns found.\n");
                reader.close();
                

                if(cmd.hasOption("p")){
                    hasInstructions = true;
                    instructions = cmd.getOptionValue("p");
                }
            }else{
                logger.error("Invalid input.");
                logger.error("PATH NOT COMPUTED");
            }
            
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\"); 
            logger.error("PATH NOT COMPUTED");
        }

        logger.info("**** Computing path\n");

        Maze maze = new Maze();
        maze.initializeMaze(rows, cols, filePath);

        maze.findStartEndPositions();
        logger.info("Start: x, y = " + maze.getStartPosition()[0] + ", " + maze.getStartPosition()[1]);
        logger.info("End: x, y = " + maze.getFinishPosition()[0] + ", " + maze.getFinishPosition()[1] + "\n");

        Runner runner;
        if(hasInstructions){
            runner = new InputRunner(Runner.Direction.RIGHT, maze.getStartPosition(), instructions);
        }else{
            runner = new RightHandRunner(Runner.Direction.RIGHT, maze.getStartPosition());
        }
        
        System.out.println((runner.solveMaze(maze)));

        logger.info("** End of MazeRunner");
    }
}
