package competion.filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import competion.app.Runner;
import competion.filehandling.Writer;

public class TextWriter extends Writer{
	
	@Override
	public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
		File resultFile = new File(dataDirectory, resultFilepath);
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, true)))) {
			System.out.println(dataDirectory);
			pw.println("Results");
			int n = 1;
			for (Runner runner : runners) {
				pw.print(n + ". ");
				pw.println(runner.toString());
				n++;
			}
		}
	}
}
