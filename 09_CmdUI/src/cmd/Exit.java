package cmd;

import java.io.File;

public class Exit extends Command {

	@Override
	public String execute(File actualDir) {
		if (params.length == 1) {
			CmdEditor.endProgram(false);
			return "Closing program.";
		}
		return null;
	}
}
