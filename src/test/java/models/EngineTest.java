package models;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EngineTest {

    @DataProvider(name = "orientations")
    public Object[][] orientation() {
        return new Object[][]{
                {Orientation.NORTH, Instruction.LEFT, Orientation.WEST},
                {Orientation.NORTH, Instruction.RIGHT, Orientation.EAST},
                {Orientation.NORTH, Instruction.FORWARD, Orientation.NORTH},
                {Orientation.SOUTH, Instruction.LEFT, Orientation.EAST},
                {Orientation.SOUTH, Instruction.RIGHT, Orientation.WEST},
                {Orientation.SOUTH, Instruction.FORWARD, Orientation.SOUTH},
                {Orientation.WEST, Instruction.RIGHT, Orientation.NORTH},
                {Orientation.WEST, Instruction.LEFT, Orientation.SOUTH},
                {Orientation.WEST, Instruction.FORWARD, Orientation.WEST},
                {Orientation.EAST, Instruction.LEFT, Orientation.NORTH},
                {Orientation.EAST, Instruction.RIGHT, Orientation.SOUTH},
                {Orientation.EAST, Instruction.FORWARD, Orientation.EAST}
        };
    }

    @DataProvider(name = "moves")
    public Object[][] moves() {
        return new Object[][]{
                {0, 0, Orientation.NORTH, Instruction.FORWARD, 0, 1, Orientation.NORTH},
                {0, 5, Orientation.NORTH, Instruction.FORWARD, 0, 5, Orientation.NORTH},
                {0, 0, Orientation.EAST, Instruction.FORWARD, 0, 1, Orientation.EAST},
                {5, 0, Orientation.EAST, Instruction.FORWARD, 5, 0, Orientation.EAST},
                {5, 0, Orientation.WEST, Instruction.FORWARD, 4, 0, Orientation.WEST},
                {0, 0, Orientation.WEST, Instruction.FORWARD, 0, 0, Orientation.WEST},
                {0, 5, Orientation.SOUTH, Instruction.FORWARD, 0, 4, Orientation.SOUTH},
                {0, 0, Orientation.SOUTH, Instruction.FORWARD, 0, 0, Orientation.SOUTH}
        };
    }

    @Test(dataProvider = "orientations")
    public void should_change_orientation_based_on_instruction(Orientation start, Instruction instruction, Orientation end) {
        // GIVEN
        Engine engine = new Engine();
        // WHEN
        Orientation orientation = engine.turn(start, instruction);
        // THEN
        Assertions.assertThat(orientation)
                .isEqualTo(end);
    }

    @Test(dataProvider = "moves")
    public void should_move_mower(int startX, int startY, Orientation startOrientation, Instruction instruction,
                                  int endX, int endY, Orientation endOrientation) {
        // GIVEN
        Engine engine = new Engine()
                .setGridMaxX(5)
                .setGridMaxY(5);

        Mower mower = new Mower()
                .setX(startX)
                .setY(startY)
                .setOrientation(startOrientation)
                .setEngine(engine);

        engine.setMower(mower);

        // WHEN
        engine.move(instruction);

        // THEN
        Assertions.assertThat(mower)
                .extracting("x", "y", "orientation")
                .contains(endX, endY, endOrientation);
    }

}
