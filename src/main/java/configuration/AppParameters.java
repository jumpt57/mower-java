package configuration;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import lombok.Data;

@Data
public class AppParameters {

    @Parameter(names = "-file", description = "Full path of the file to parse", required = true)
    private String file;

    public static AppParameters parseParameters(String[] args) {
        AppParameters appParameters = new AppParameters();
        JCommander.newBuilder()
                .addObject(appParameters)
                .build()
                .parse(args);

        return appParameters;
    }

}
