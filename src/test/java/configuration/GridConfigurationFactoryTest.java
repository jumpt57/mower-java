package configuration;

import configuration.GridConfigurationFactory;
import models.GridConfiguration;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class GridConfigurationFactoryTest {

    @Test
    public void should_map_file_to_grid_configuration() throws Exception {
        // GIVEN
        GridConfigurationFactory fileReader = new GridConfigurationFactory();
        // WHEN
        final GridConfiguration gridConfiguration = fileReader.get();
        // THEN
        Assertions.assertThat(gridConfiguration)
                .extracting("gridMaxCols", "gridMaxRows", "mowerConfigurations.size")
                .contains(5, 5, 2);
    }

}
