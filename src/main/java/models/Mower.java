package models;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Mower {

    private Integer x;

    private Integer y;

    private Orientation orientation;

    private Engine engine;

    public void followInstructions(@NonNull List<Instruction> instructions) {
        instructions.forEach(instruction -> engine.move(instruction));
    }

    public String getPosition() {
        return String.format("%d %d %s", x, y, orientation.getName());
    }
}
