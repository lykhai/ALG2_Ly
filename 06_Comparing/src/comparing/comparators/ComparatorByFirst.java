package comparing.comparators;

import comparing.Student;

public class ComparatorByFirst implements ComparatorInterface{

	@Override
	public boolean bigger(Object o1, Object o2) {
		if(((Student)o1).getFirstName().compareTo(((Student)o2).getFirstName()) > 0)
			return true;
		return false;
	}

}
