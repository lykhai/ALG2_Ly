package comparing;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import comparing.comparators.ComparatorByFirst;
import comparing.comparators.CompareInterface;
import comparing.comparators.MyComparing;

public class Comparing {

	public static void main(String[] args) {
		Student[] students = Datasource.loadDataAsArray();
		
		students[0].addGrades(1, 2, 3);
		students[1].addGrades(5);
		students[1].addGrades(3,3,1,2,5,8,9,7,6,7);
		students[2].addGrades(1, 2, 1);
		
		System.out.println();
		
		System.out.println(students[0].equals(students[1])); 
		
		System.out.println("Sort by number");
		Arrays.sort(students);
		print(students);
		
		List<Student> students1 = Datasource.loadDataAsList();
		System.out.println("Sort by number");
		Collections.sort(students1);
		print(students1);
		
		System.out.println("Sort by first name");
		Arrays.sort(students, new ComparatorByFirstName());
		print(students);
		
		System.out.println("Sort by last name");
		Arrays.sort(students, new Comparator<Student>() { //vytvoreni anonymni tridy

			@Override
			public int compare(Student o1, Student o2) {
				Collator col = Collator.getInstance(new Locale("cs", "CZ"));
				return col.compare(o1.getLastName(), o2.getLastName());
//				return o1.getLastName().compareTo(o2.getLastName()); //trideni Stringu podle ASCII
			}
		});
		print(students);
		
		System.out.println("Sort by marks");
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
//				return (o1.getAvgGrade() > o2.getAvgGrade());
				return 0;
			}
		});

	}
	
	
	private static void sort(CompareInterface[] array) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 1; j < array.length-i; j++) {
				if (array[j-1].isSmaller(array[j])) {
					CompareInterface temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
	
	public static void print(List array) {
		for (Object o : array) {
			System.out.println(o);
		}
	}
	public static void print(Object[] array) {
		for (Object student : array) {
			System.out.println(student);
		}
	}
}
