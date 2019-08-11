import configuration.AppParameters;
import configuration.GridConfigurationFactory;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import models.Engine;
import models.GridConfiguration;
import models.Mower;

@Slf4j
@AllArgsConstructor
public class Application {

    public static void main(String[] args) throws Exception {
        AppParameters appParameters = AppParameters.parseParameters(args);
        Application application = new Application();
        application.start(appParameters.getFile());
    }

    private void start(@NonNull String file) throws Exception {

        GridConfiguration gridConfiguration = new GridConfigurationFactory().get(file);

        gridConfiguration.getMowerConfigurations()
                .forEach(mowerConfiguration -> {

                    Engine engine = new Engine()
                            .setGridMaxX(gridConfiguration.getGridMaxCols())
                            .setGridMaxY(gridConfiguration.getGridMaxRows());

                    Mower mower = new Mower()
                            .setX(mowerConfiguration.getX())
                            .setY(mowerConfiguration.getY())
                            .setOrientation(mowerConfiguration.getOrientation());

                    mower.setEngine(engine);
                    engine.setMower(mower);

                    mower.followInstructions(mowerConfiguration.getInstructions());

                    log.info(mower.getPosition());
                });
    }

}
