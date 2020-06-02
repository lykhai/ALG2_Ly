package comparing;

import java.util.Arrays;

import comparing.comparators.CompareInterface;

public class Student implements CompareInterface, Comparable<Student>{
	private String firstName;
	private String lastName;
	private int age;
	private int number;
	
	//TODO
	private double[] grades; //max 10
	private final int numOfGrades = 10;
	private int countGrades = 0;
	private double average;
	
	public Student(String firstName, String lastName, int number, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.number = number;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public int getNumber() {
		return number;
	}

	//Grades
	public void addGrades(double...grade) {
		for (double i : grade) {
			this.grades[0] = i;
		}
	}
	public double getAvgGrade() {
		for (int i = 0; i < grades.length; i++) {
			average += this.grades[i];
		}
		if (average == 0) {
			throw new IllegalArgumentException("You did not add any marks.");
		}
		return average/grades.length;
	}
	
	

	@Override
	public String toString() {
		return "\t" + firstName + "\t" + lastName + "\t" + age + "\t" + number;
	}
	//------------------------------------------------
	public boolean startLater(Student student) {
		return this.number > student.number;
	}
	public boolean isOlder(Student student) {
		return this.age > student.age;
	}
	
	//implementace CompareInterface
	@Override
	public boolean isSmaller(CompareInterface o) {
		return this.number > ((Student)o).number;
	}
	
	
//	@Override
//	public int compareTo(Object o) {	//vraci zapornou nulu nebo kladne int
//		return this.number - ((Student)o).number;
//	}

	@Override
	public int compareTo(Student o) {
		return this.number - o.number;
	}
	//pri zmene equals zmenit i hash
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + this.number;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		final Student other = (Student) obj;
		if (this.number != other.number)
			return false;
		return true;
	}
	
	
	
}
