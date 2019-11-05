<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="j2eeMiniProj.StudentsDao" import="j2eeMiniProj.Students" import="java.util.ArrayList"
import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<Students> list=StudentsDao.display();
	out.print("<table border='1' width='100%'");
	out.print("<tr><th>RollNo</th><th>FName</th><th>LName</th><th>Course</th><th>Result</th></tr>");
	for(Students s:list){
		out.print("<tr><td>"+s.getRollno()+"</td><td>"+s.getFname()+"</td><td>"+s.getLname()+"</td><td>"+s.getCourse()+"</td><td>"+s.getResult()+"</td></tr>");
	}
	out.print("</table>");
%>

</body>
</html>