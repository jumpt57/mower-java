import configuration.GridConfigurationFactory;
import lombok.extern.slf4j.Slf4j;
import models.Engine;
import models.GridConfiguration;
import models.Mower;

@Slf4j
public class Application {

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.start();
    }

    private void start() throws Exception {

        GridConfiguration gridConfiguration = new GridConfigurationFactory().get();

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
