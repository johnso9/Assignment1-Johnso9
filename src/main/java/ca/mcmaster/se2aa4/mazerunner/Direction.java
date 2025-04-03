package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
    RIGHT, 
    LEFT, 
    UP, 
    DOWN;

    public Direction toRight(){
        return switch (this) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }

    public Direction toLeft(){
        return switch (this) {
            case UP -> LEFT;
            case RIGHT -> UP;
            case DOWN -> RIGHT;
            case LEFT -> DOWN;
        };
    }
}