
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.gson.Gson;

/**
 * Servlet Filter implementation class SearchFilter
 */
//@WebFilter("/SearchFilter")
public class SearchFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SearchFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public String ResponseData = "";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entered");
		BufferedReader br = request.getReader();
		String line, name = "", type = "", res = "";

		while ((line = br.readLine()) != null) {
			String input[] = line.split(":|,");
			System.out.println("jnkn " + line);

			name = input[1].substring(1, input[1].length() - 1);
			type = input[3].substring(1, input[3].length() - 2);
		}
		DataBase db = new DataBase();
		ArrayList<Data> data = db.getAl();

		for (int i = 0; i < data.size(); i++) {
			if (type.equals("name")) {
				if (data.get(i).getName().equals(name)) {
					res += data.get(i).getName() + " " + data.get(i).getEmail() + " " + data.get(i).getCollege() + " "
							+ data.get(i).getPno();
					System.out.println("data is " + res);
				}
			} else if (type.equals("college")) {
				if (data.get(i).getCollege().equals(name)) {
					res += data.get(i).getName() + " " + data.get(i).getEmail() + " " + data.get(i).getCollege() + " "
							+ data.get(i).getPno();
					System.out.println("data is " + res);
				}
			}
			res += "&";
		}

		String json = new Gson().toJson(data);
		try {
			JSONArray array = new JSONArray(json);
			System.out.println(array);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.getWriter().append(res);
		chain.doFilter(request, response);
		System.out.println("Exited");
	}

	public String getResponse() {
		return ResponseData;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
