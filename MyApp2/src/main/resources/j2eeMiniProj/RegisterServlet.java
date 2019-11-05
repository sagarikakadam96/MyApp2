package j2eeMiniProj;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String rollno=request.getParameter("rollno");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String course=request.getParameter("course");
		String result=request.getParameter("result");

		
		Students s=new Students();
		s.setRollno(rollno);
		s.setFname(fname);
		s.setLname(lname);
		s.setCourse(course);
		s.setResult(result);

		
		int status=StudentsDao.register(s);
		if(status>0){
			out.print("<p>Record registered successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to register");
		}
		
		out.close();
	}

}
