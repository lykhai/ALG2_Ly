package competion.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.List;

import competion.app.Runner;

public abstract class Writer {
	
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    public abstract void saveResults(String resultFilepath, List<Runner> runners) throws IOException;

}
