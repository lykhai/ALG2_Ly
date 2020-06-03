package competion.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import competion.app.Competition;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Competition c = new Competition();
		System.out.println("Enter files to be read [start.txt, finish.txt]");
		try {
			while (true) {
				try {
					String startFile = sc.next();
					String finishFile = sc.next();
					c.load(startFile, finishFile);
					break;
				} catch (FileNotFoundException e) {
					System.out.println("File does not exist. Try it again");
				}
			}
			System.out.println(c.getResults());
			System.out.println("Enter input file: ");
			String resultFile = sc.next();
			c.saveResults(resultFile);
			System.out.println("Data successfully saved.");
		} catch (IOException e) {
			System.out.println("Fail to read and write data.");
		}
	}
}
