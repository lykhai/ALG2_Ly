package cmd;

import java.io.File;

public class Cd extends Command {

	@Override
	public String execute(File actualDir) {
		File dir = new File(actualDir.getAbsolutePath());
		
		if (params.length == 2) {
			if (!"..".equals(params[1]) && dir.exists()) {
				CmdEditor.changeActDir(new File(dir + File.separator + params[1]));
				return "Directory changed";
				
			} else if ("..".equals(params[1])) {
				CmdEditor.changeActDir(actualDir.getParentFile());
				return "Directory changed";
				
			} else {
				return "No such directory";
			}
		}
		return null;
	}
}
