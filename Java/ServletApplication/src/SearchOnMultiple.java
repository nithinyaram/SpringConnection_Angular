
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchOnMultiple
 */
//@WebServlet("/SearchOnMultiple")
public class SearchOnMultiple extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchOnMultiple() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		BufferedReader br = request.getReader();
		String line, name = "", college = "", res = "";

		while ((line = br.readLine()) != null) {
			String input[] = line.split(":|,");
			name = input[1].substring(1, input[1].length() - 1);
			college = input[3].substring(1, input[3].length() - 2);
		}
		
		DataBase db = new DataBase();
		ArrayList<Data> data = db.getAl();

		SearchRecords toBeSearch=new SearchRecords(name.trim(), college.trim());
		for (int i = 0; i < data.size(); i++) {
			SearchRecords compare=new SearchRecords((data.get(i).getName()).trim(), (data.get(i).getCollege()).trim());
			if(compare.hashCode()==toBeSearch.hashCode()) {
				out.println((data.get(i).getName())+" knjknkjn "+data.get(i).getCollege());
				System.out.println("Same Obj");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
