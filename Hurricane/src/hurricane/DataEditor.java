package hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class DataEditor implements HurricaneInterface{
	private ArrayList<Hurricane> hrc = new ArrayList<>();

	@Override
	public void loadData() throws FileNotFoundException, IOException {
		File loadData = new File("hurricanedata.txt");
		Scanner load = new Scanner(loadData/*, "utf-8"*/);
		
		while (load.hasNext()) {
			int year = load.nextInt();
			String month = load.next();
			int preasure = load.nextInt();
			int speed = load. nextInt();
			String name = load.next();
			
			Hurricane h = new Hurricane(year, month, preasure, speed, name);
			hrc.add(h);
		}
		load.close();
	}
	
	@Override
	public String dispHuricanes(int y1, int y2) {
		StringBuilder sb = new StringBuilder();
		for (Hurricane h : hrc) {
			if ((h.getYear() >= y1) && (h.getYear() <= y2)) {
				sb.append(h + "\n");
			}
		}
		return sb.toString();
	}
	
	@Override
	public String getHuricane(String name) {
		for (Hurricane h : hrc) {
			if (h.getName().equals(name)) {
				return "Category: " + h.getCathegory() + "\tspeed: " + h.getSpeedInKm();
			}
		}
		return ("Huricane does not found.");
	}

	
	@Override
	public String sortBySpeed() {
		Collections.sort(hrc, Comparator.comparing(Hurricane::getSpeedInKm)); 
		StringBuilder sb = new StringBuilder();
		for (Hurricane h : hrc) {
			sb.append(h.toString() + "\n");
		}
		return sb.toString();
	}

}
