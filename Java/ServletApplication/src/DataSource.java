

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataSource
 */
//@WebServlet("/DataSource")
public class DataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("do get method ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/html");
		BufferedReader br=request.getReader();
		String data;
		
		Data obj;
		DataBase datasrc=new DataBase();
		while((data=br.readLine())!=null) {
			System.out.println(data);
			obj=new Data();
			String input[]=data.split(":|,");
			System.out.println(input[1].substring(1, input[1].length()-1));
			System.out.println(input[3].substring(1, input[3].length()-1));
			System.out.println(input[5].substring(1, input[5].length()-1));
			System.out.println(input[7].substring(1, input[7].length()-2));
			
			obj.setName(input[1].substring(1, input[1].length()-1));
			obj.setEmail(input[3].substring(1, input[3].length()-1));
			obj.setCollege(input[5].substring(1, input[5].length()-1));
			obj.setPno(input[7].substring(1, input[7].length()-2));
			datasrc.add(obj);
			
			System.out.println(obj.getName());
			System.out.println(obj.getCollege());
			System.out.println(datasrc.getAl().size());
		}
		
		response.getWriter().append("do post method ");

		doGet(request, response);
	}

}
