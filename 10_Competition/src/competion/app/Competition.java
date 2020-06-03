package competion.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

import competion.filehandling.BinaryWriter;
import competion.filehandling.TextWriter;
import competion.filehandling.Writer;
import competion.utils.IllegalFilenameException;

public class Competition {
	
	private ArrayList<Runner> runners = new ArrayList<>();

	public void load(String startFilepath, String finishFilepath) throws FileNotFoundException, IOException {

		if (!startFilepath.contains("start")) {
			throw new IllegalFilenameException("File need to contain start");
		}

		File startFile = new File(startFilepath);
		try (Scanner inStart = new Scanner(startFile)) {
			while (inStart.hasNext()) {
				
				int number = inStart.nextInt();
				String firstname = inStart.next();
				String lastname = inStart.next();
				String startTime = inStart.next();
				Runner r = new Runner(number, firstname, lastname);
				r.setStartTime(startTime);
				runners.add(r);
			}
		}

		
		File finishFile = new File(finishFilepath);
		BufferedReader inFinish = null;
		Runner r;
		try {
			inFinish = new BufferedReader(new FileReader(finishFile));
			String line;
			while ((line = inFinish.readLine()) != null) {
				String[] parts = line.split("[ ]+");
				
				try { 
					r = findRunner(Integer.parseInt(parts[0]));
					r.setFinishTime(parts[1]);
				} catch (NoSuchElementException e) {
					System.err.print(e.getMessage());
				}
			}
		} finally {
			if (inFinish != null)
				inFinish.close();
		}
	}

	private Runner findRunner(int number) {
		for (Runner runner : runners) {
			if (runner.getNumber() == number) {
				return runner;
			}
		}
		throw new NoSuchElementException("Runner num. " + number + " did not particular.");
	}

	public String getResults() {
		Collections.sort(runners);
		StringBuilder sb = new StringBuilder();
		int n = 1;
		for (Runner runner : runners) {
			sb.append(String.format("%-2d. %s%n", n, runner));
			n++;
		}
		return sb.toString();
	}

	public void saveResults(String resultFilepath) throws IOException {
		Collections.sort(runners);
		Writer w = null;
		if (resultFilepath.endsWith(".txt")) {
			w = new TextWriter();
		} else if (resultFilepath.endsWith(".dat")) {
			w = new BinaryWriter();
		} else {
			throw new IllegalArgumentException("Unsuported file extension");
		}
		w.saveResults(resultFilepath, runners);
	}
}
