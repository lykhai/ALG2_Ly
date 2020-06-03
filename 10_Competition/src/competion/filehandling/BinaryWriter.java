package competion.filehandling;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import competion.app.Runner;

public class BinaryWriter extends Writer {
	
	@Override
	public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
		File resultFile = new File(dataDirectory, resultFilepath);
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFile))) {
			dos.writeUTF("Results");
			
			int n = 1;
			for (Runner runner : runners) {
				dos.writeInt(n);
				// dos.writeChar('.');
				// dos.writeUTF(resultFilepath);
				dos.writeUTF(runner.getFirstname());
				
				int nChars = runner.getLastname().length();
				dos.writeInt(nChars);
				for (int i = 0; i < nChars; i++) {
					dos.writeChar(runner.getLastname().charAt(i));
				}
				dos.writeInt(runner.getStartTime().toSecondOfDay());
				dos.writeLong(runner.getFinishTime().toNanoOfDay());
				dos.writeLong(runner.runningTime().toNanoOfDay()); 
				n++;
			}
		}
	}
}
