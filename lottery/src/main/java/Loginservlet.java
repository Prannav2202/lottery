

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Loginservlet
 */
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String password=request.getParameter("password");
//		System.out.println(name);
//		System.out.println(password);
		Login obj=new Login(name,password);
		obj.check();
		int count=obj.getCount();
		if(count==1) {
			RequestDispatcher rd=request.getRequestDispatcher("intro.html");  
			rd.forward(request, response);
		}
		else {
//			RequestDispatcher rd=request.getRequestDispatcher("login.html");  
//			rd.forward(request, response);
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('Wrong password or Username please check and try again');"); 
			out.println("location='login.html';"); 
			out.println("</script>"); 
		}
		doGet(request, response);
	}


}
