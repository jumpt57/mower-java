package models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class MowerConfiguration {

    private Integer x;

    private Integer y;

    private Orientation orientation;

    private List<Instruction> instructions;

}
