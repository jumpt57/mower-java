package models;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Engine {

    private Mower mower;
    private Integer gridMaxY;
    private Integer gridMaxX;

    void move(@NonNull Instruction instruction) {

        if (instruction == Instruction.FORWARD) {
            switch (mower.getOrientation()) {
                case NORTH:
                    if (mower.getY() + 1 <= gridMaxY) {
                        mower.setY(mower.getY() + 1);
                    }
                    break;
                case SOUTH:
                    if (mower.getY() - 1 >= 0) {
                        mower.setY(mower.getY() - 1);
                    }
                    break;
                case EAST:
                    if (mower.getX() + 1 <= gridMaxX) {
                        mower.setX(mower.getX() + 1);
                    }
                    break;
                case WEST:
                    if (mower.getX() - 1 >= 0) {
                        mower.setX(mower.getX() - 1);
                    }
                    break;
            }
        }

        mower.setOrientation(turn(mower.getOrientation(), instruction));
    }

    Orientation turn(@NonNull Orientation baseOrientation, @NonNull Instruction instruction) {

        switch (baseOrientation) {
            case NORTH:
                switch (instruction) {
                    case RIGHT:
                        return Orientation.EAST;
                    case LEFT:
                        return Orientation.WEST;
                    default:
                        return baseOrientation;
                }
            case SOUTH:
                switch (instruction) {
                    case RIGHT:
                        return Orientation.WEST;
                    case LEFT:
                        return Orientation.EAST;
                    default:
                        return baseOrientation;
                }
            case EAST:
                switch (instruction) {
                    case RIGHT:
                        return Orientation.SOUTH;
                    case LEFT:
                        return Orientation.NORTH;
                    default:
                        return baseOrientation;
                }
            case WEST:
                switch (instruction) {
                    case RIGHT:
                        return Orientation.NORTH;
                    case LEFT:
                        return Orientation.SOUTH;
                    default:
                        return baseOrientation;
                }
            default:
                return baseOrientation;
        }
    }

}
