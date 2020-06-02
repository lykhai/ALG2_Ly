package cmd;

import java.io.File;

public class Mkdir extends Command{

	@Override
	public String execute(File actualDir) {
		File newFile = new File(params[1]);
		if (newFile.mkdir()) {
			return "File successfully created..";
		}
		return "File alreadz exists";
	}

}
