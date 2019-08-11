package configuration;

import models.GridConfiguration;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class GridConfigurationFactoryTest {

    @Test
    public void should_map_file_to_grid_configuration() throws Exception {
        // GIVEN
        GridConfigurationFactory gridConfigurationFactory = new GridConfigurationFactory();

        final String filePath = GridConfiguration.class.getClassLoader().getResource("data.txt").getFile();
        // WHEN
        final GridConfiguration gridConfiguration = gridConfigurationFactory.get(filePath);
        // THEN
        Assertions.assertThat(gridConfiguration)
                .extracting("gridMaxCols", "gridMaxRows", "mowerConfigurations.size")
                .contains(5, 5, 2);
    }

}
