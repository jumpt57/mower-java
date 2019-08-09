package models;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MowerTest {

    @Test
    public void should_follow_all_instruction() {
        // GIVEN

        Engine engine = new Engine()
                .setGridMaxY(5)
                .setGridMaxX(5);

        Mower mower = new Mower()
                .setX(1)
                .setY(2)
                .setOrientation(Orientation.NORTH)
                .setEngine(engine);

        engine.setMower(mower);

        List<Instruction> instructions = Arrays.asList(
                Instruction.LEFT, Instruction.FORWARD,
                Instruction.LEFT, Instruction.FORWARD,
                Instruction.LEFT, Instruction.FORWARD,
                Instruction.LEFT, Instruction.FORWARD,
                Instruction.FORWARD);

        // WHEN
        mower.followInstructions(instructions);

        //THEN
        Assertions.assertThat(mower)
                .extracting("x", "y", "orientation")
                .contains(1, 3, Orientation.NORTH);

    }

}
