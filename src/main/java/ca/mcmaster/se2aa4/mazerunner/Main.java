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

        Option maze = new Option("i", "input", true, "input maze filepath");
        Option path = new Option("p", "input", true, "input maze path for testing");
        options.addOption(maze);
        options.addOption(path);
        CommandLine cmd;
        CommandLineParser parser = new BasicParser();

        logger.info("** Starting Maze Runner");
        try {
            cmd = parser.parse(options, args);
            if(cmd.hasOption("i")) {
                logger.trace("**** Reading the maze from file " + args[1]);
                BufferedReader reader = new BufferedReader(new FileReader(args[1]));
                String line;
                while ((line = reader.readLine()) != null) {
                    StringBuilder mazeConstruction = new StringBuilder();
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            mazeConstruction.append("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            mazeConstruction.append("PASS ");
                        }
                    }
                    logger.info(mazeConstruction.toString());
                }
            }else{
                logger.error("Invalid input.");
            }
            
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\"); 
        }
        logger.info("**** Computing path");
        logger.error("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
