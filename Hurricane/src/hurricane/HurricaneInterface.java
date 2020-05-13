package hurricane;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HurricaneInterface {

	public void loadData() throws FileNotFoundException, IOException;
	public String dispHuricanes(int y1, int y2);
	public String getHuricane(String name);
	public String sortBySpeed();
	
	
	
}
