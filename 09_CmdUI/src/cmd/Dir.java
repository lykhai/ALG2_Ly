package cmd;

import java.io.File;
import java.util.Date;

public class Dir extends Command {
	File[] files;
	
	@Override
	public String execute(File actualDir) {
		if (params.length == 1) {
			files = actualDir.listFiles();
			return dirToString(files);
		}
		else if ((params.length == 2) && (params[1].equals("-r"))) {
			return recursionDirE(actualDir, "-");
		}
		else if ((params.length == 3) && (params[1].equals("-e"))) {
			return dirFileByExtension(actualDir, params[2]);
		}
		return null;
	}

	private String dirFileByExtension(File actDir, String extension) {
		String fileName = "";
		StringBuilder sb = new StringBuilder();
		files = actDir.listFiles();
		for (File f : files) {
			fileName = f.getName();
			
			if (fileName.endsWith(extension)) {
				sb.append(fileName + "\n");
			}
		}
		return sb.toString();
	}
	
	private String recursionDirE(File actDir, String dash) {
		StringBuilder sbb = new StringBuilder();
		files = actDir.listFiles();
		
        for(File f : files){           
            if (f.isDirectory()) {
                sbb.append(dash + " " + f.getName() + "\n");
                File subFiles = new File(f.getParent() + File.separator + f.getName());
                sbb.append(recursionDirE(subFiles, dash + "-"));
            }
        }
        return sbb.toString();
	}

	private String dirToString(File[] files) {
		StringBuilder sb = new StringBuilder("");
		for (File file : files) {
			if (file.isDirectory()) {
				sb.append(String.format("%s%n", file.getName()));
			} else {
				sb.append(String.format("%-20s%6d ", file.getName(), file.length()));
				sb.append(new Date(file.lastModified())).append("\n");
			}
		}
		return sb.toString();
	}
}
