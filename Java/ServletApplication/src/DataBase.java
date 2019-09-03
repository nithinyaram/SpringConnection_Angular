import java.util.ArrayList;

public class DataBase {
	private static ArrayList<Data> al=new ArrayList<Data>();

	public static ArrayList<Data> getAl() {
		return al;
	}

	public static void add(Data data) {
		al.add(data);
	}
	
}
