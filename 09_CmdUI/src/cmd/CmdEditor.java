package cmd;

import java.io.File;

public class CmdEditor implements CmdInterface{
	private static boolean isRunning;
	private static File actualDir;
	private Command command;

	public CmdEditor() {
		isRunning = true;
		actualDir = new File(System.getProperty("user.dir"));
	}

	public static void endProgram(boolean state) {
		isRunning = state;
	}
	
	@Override
	public boolean isRunning() {
		return isRunning;
	}

	@Override
	public String getActualDir() {
		return actualDir.getAbsolutePath();
	}
	
	public static void changeActDir(File path) {
		actualDir = path;
	}

	@Override
	public String parseAndExecute(String line) {
		// parse
		command = Parser.parse(line);
		// execute
		return command.execute(actualDir);
	}
}
