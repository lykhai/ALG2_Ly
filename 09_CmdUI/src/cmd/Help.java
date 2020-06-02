package cmd;

import java.io.File;

public class Help extends Command {

	@Override
	public String execute(File actualDir) {
		String help = "HELP\n" + String.format("%-7s %s\n", "help", "Display help")
				+ String.format("%-7s %s\n", "dir", "Display list of files and folders")
				+ String.format("%-7s %s\n", "dir -r", "Display list of files by recursive method")
				+ String.format("%-7s %s\n", "dir -e [.txt, .vlc, ..]", "Display list of files by entered extension");
		
		return help;
	}
}
