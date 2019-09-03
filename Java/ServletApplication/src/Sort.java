

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sort
 */
//@WebServlet("/Sort")
public class Sort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br=request.getReader();
		String data;
		String line;
		String  name = "", type="";
		while((line=br.readLine())!=null) {
			String input[] = line.split(":|,");
			System.out.println("jnkn " + line);

			type = input[1].substring(1, input[1].length() - 2);
			System.out.println(name+" "+type);
		}
		DataBase db= new DataBase();
		
		Comparator comparator =new NameComparator() ;
		Collections.sort(db.getAl(),comparator);
		
//		response.getWriter().append("SOrt ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
