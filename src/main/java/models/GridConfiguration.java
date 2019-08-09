package models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class GridConfiguration {

    private int gridMaxCols;

    private int gridMaxRows;

    private List<MowerConfiguration> mowerConfigurations;

}
