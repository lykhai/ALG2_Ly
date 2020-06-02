package comparing.comparators;

import comparing.Student;

public class ComparatorByNum implements ComparatorInterface{

	public boolean bigger(Object o1, Object o2) {
		return (((Student)o1).getNumber() > ((Student)o2).getNumber());
	}
}
