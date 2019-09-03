import java.util.Comparator;

public class NameComparator  implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Data s1=(Data)o1;  
		Data s2=(Data)o2;  
		  
		return s1.getName().compareTo(s2.getName());
	}

}