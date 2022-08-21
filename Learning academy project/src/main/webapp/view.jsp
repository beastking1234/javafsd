<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"
import="org.hibernate.Session"
import="org.hibernate.SessionFactory"
import="org.hibernate.cfg.Configuration"
import="java.util.Iterator"
import="beans.Classes"
import="beans.Subject"
import="beans.Teacher"
import="beans.Student"
import="java.util.Set"
import="javax.persistence.TypedQuery"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="400" border="1">  
		<tr><th>Class Id</th><th>Class</th><th>Subjects</th><th>Teachers</th><th>Students</th></tr>                       
		<%  
			Configuration cf=new Configuration();    
			SessionFactory sf = cf.configure().buildSessionFactory();  
			Session session1 =sf.openSession();
			
			//Using from Clause  
			@SuppressWarnings("unchecked")
			List<Classes> list= session1.createQuery("from Classes").list();
			for(Classes e : list) {
				int id = e.getClassId(); 
				String name =e.getClassName();  
				Set<Subject> subs =e.getSubjects();              
				Set<Teacher> teachers =e.getTeachers();              
				Set<Student> students =e.getStudents();
			                
		%>                    
		<tr>  
		<td><%=id%></td>  
		<td><%=name%></td>  
		<td><%
				for(Subject s: subs){
					out.println(s.getSubjectName()+"<br>");
				}
		%>
		</td>  
		<td><%
				for(Teacher t: teachers){
					out.println(t.getTeacherName()+"<br>");
				}
		%></td>  
		<td><%
				for(Student st: students){
					out.println(st.getStudentName()+"<br><br>");
				}
		%></td>  
		</tr>  
		<%  
		}  
		session1.close();  
		%>  
	</table>
</body>
</html>