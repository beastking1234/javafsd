package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Classes;
import beans.Student;
import beans.Subject;
import beans.Teacher;

/**
 * Servlet implementation class AddClassServlet
 */
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out = response.getWriter();
    	
    	String className = request.getParameter("class-name");
		
		String subject1 = request.getParameter("sub1-name");
		String subject2 = request.getParameter("sub2-name");
		String subject3 = request.getParameter("sub3-name");
		
		String sub1_teacher = request.getParameter("teacher1-name");
		String sub2_teacher = request.getParameter("teacher2-name");
		String sub3_teacher = request.getParameter("teacher3-name");
		
		String std1 = request.getParameter("student1-name");
		String std2 = request.getParameter("student2-name");
		String std3 = request.getParameter("student3-name");
		String std4 = request.getParameter("student4-name");
		
		
		
		Classes classObj = new Classes();
		classObj.setClassName(className);
		
		Subject s1 = new Subject();
		s1.setSubjectName(subject1);
		Subject s2 = new Subject();
		s2.setSubjectName(subject2);
		Subject s3 = new Subject();
		s3.setSubjectName(subject3);
		
		Teacher t1 = new Teacher();
		t1.setTeacherName(sub1_teacher);
		Teacher t2 = new Teacher();
		t2.setTeacherName(sub2_teacher);
		Teacher t3 = new Teacher();
		t3.setTeacherName(sub3_teacher);
		
		//students creation
		Student st1 = new Student();
		st1.setStudentName(std1);
		Student st2 = new Student();
		st2.setStudentName(std2);
		Student st3 = new Student();
		st3.setStudentName(std3);
		Student st4 = new Student();
		st4.setStudentName(std4);
		
		classObj.getSubjects().add(s1);
		classObj.getSubjects().add(s2);
		classObj.getSubjects().add(s3);
		
		s1.getClasses().add(classObj);
		s2.getClasses().add(classObj);
		s3.getClasses().add(classObj);
		
		classObj.getTeachers().add(t1);
		classObj.getTeachers().add(t2);
		classObj.getTeachers().add(t3);
		
		t1.getClasses().add(classObj);
		t2.getClasses().add(classObj);
		t3.getClasses().add(classObj);
		
		t1.getSubjects().add(s1);
		t2.getSubjects().add(s2);
		t3.getSubjects().add(s3);
		
		classObj.getStudents().add(st1);
		classObj.getStudents().add(st2);
		classObj.getStudents().add(st3);
		classObj.getStudents().add(st4);
		
		HttpSession httpSession = request.getSession();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(classObj);
		session.getTransaction().commit();
		
 	}

}
