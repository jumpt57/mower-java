package configuration;

import models.GridConfiguration;
import models.Instruction;
import models.MowerConfiguration;
import models.Orientation;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GridConfigurationFactory {

    public GridConfiguration get() throws Exception {

        URL url = Optional.ofNullable(GridConfigurationFactory.class.getClassLoader().getResource("data.txt"))
                .orElseThrow(() -> new IllegalStateException("Impossible to get file data.txt"));

        List<String> lines = Files.readAllLines(Paths.get(url.toURI()), Charset.defaultCharset());

        GridConfiguration configuration = new GridConfiguration()
                .setGridMaxCols(intFromChar(lines.get(0), 0))
                .setGridMaxRows(intFromChar(lines.get(0), 1))
                .setMowerConfigurations(new ArrayList<>());

        for (int i = 1; i < lines.size(); i = i + 2) {

            String line1 = lines.get(i);
            String line2 = lines.get(i + 1);

            MowerConfiguration mowerConfiguration = new MowerConfiguration();
            mowerConfiguration.setX(intFromChar(line1, 0));
            mowerConfiguration.setY(intFromChar(line1, 1));
            mowerConfiguration.setOrientation(Orientation.find(stringFromChar(line1, 2)));

            List<Instruction> chars = new ArrayList<>();
            for (Character character : line2.toCharArray()) {
                chars.add(Instruction.find(String.valueOf(character)));
            }

            mowerConfiguration.setInstructions(chars);

            configuration.getMowerConfigurations().add(mowerConfiguration);
        }

        return configuration;
    }

    private int intFromChar(String s, int i) {
        return Integer.parseInt(stringFromChar(s, i));
    }

    private String stringFromChar(String s, int i) {
        return String.valueOf(s.charAt(i));
    }

}
