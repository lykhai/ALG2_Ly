package comparing;

import java.util.Arrays;
import java.util.List;

public class Datasource {
	
	private static Student[] data = {
			new Student("Bob", "Maly", 1234, 20),
			new Student("Alice", "Velka", 1136, 19),
			new Student("Cyril", "Pech", 1954, 18)
	};
	
	public static Student[] loadDataAsArray() {
		return Arrays.copyOf(data, data.length);
	}
	public static List<Student> loadDataAsList(){
		return Arrays.asList(data);
	}
}
