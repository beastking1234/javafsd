package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Classes;
import beans.Student;
import beans.Subject;
import beans.Teacher;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		//Common for all classes
		Set<Classes> classes = new HashSet<Classes>();
		
		//11th sets
		Set<Subject> subjects = new HashSet<Subject>();
		Set<Teacher> teachers = new HashSet<Teacher>();
		Set<Student> students = new HashSet<Student>();
		
		//12th sets 
		Set<Subject> twelth_subjects = new HashSet<Subject>();
		Set<Teacher> twelth_teachers = new HashSet<Teacher>();
		Set<Student> twelth_students = new HashSet<Student>();
		
		//10th
		Set<Subject> tenth_subjects = new HashSet<Subject>();
		Set<Teacher> tenth_teachers = new HashSet<Teacher>();
		Set<Student> tenth_students = new HashSet<Student>();
		
		//11th subs
		Subject maths = new Subject();
		maths.setSubjectName("11th Mathematics");
		Subject chemistry = new Subject();
		chemistry.setSubjectName("11th Chemistry");
		Subject physics = new Subject();
		physics.setSubjectName("11th Physics");
		
		//12th subs
		Subject twelth_maths = new Subject();
		twelth_maths.setSubjectName("12th Mathematics");
		Subject twelth_chemistry = new Subject();
		twelth_chemistry.setSubjectName("12th Chemistry");
		Subject twelth_physics = new Subject();
		twelth_physics.setSubjectName("12th Physics");
		
		//10th subs
		Subject tenth_science = new Subject();
		tenth_science.setSubjectName("10th Science");
		Subject tenth_maths = new Subject();
		tenth_maths.setSubjectName("10th Mathematics");
		Subject tenth_tamil = new Subject();
		tenth_tamil.setSubjectName("10th Tamil");
		
		//teachers
		Teacher t1 = new Teacher();
		t1.setTeacherName("Malar");
		Teacher t2 = new Teacher();
		t2.setTeacherName("Ashok");
		Teacher t3 = new Teacher();
		t3.setTeacherName("sekar");
		
		//10th students
		Student s1 = new Student();
		s1.setStudentName("Nandha");
		Student s2 = new Student();
		s2.setStudentName("Kumar");
		Student s3 = new Student();
		s3.setStudentName("Velu");
		Student s4 = new Student();
		s4.setStudentName("Harish");
		
		//11th students
		Student s5 = new Student();
		s5.setStudentName("Nikil");
		Student s6 = new Student();
		s6.setStudentName("Nalini");
		Student s7 = new Student();
		s7.setStudentName("Seetha");
		
		//12th students
		Student s8 = new Student();
		s8.setStudentName("Swetha");
		Student s9 = new Student();
		s9.setStudentName("Nandhini");
		Student s10 = new Student();
		s10.setStudentName("Kishore");
		Student s11 = new Student();
		s11.setStudentName("Rahul");
		
		//classes
		Classes eleventh = new Classes();
		eleventh.setClassName("Eleventh standard");
		
		Classes tenth = new Classes();
		tenth.setClassName("Tenth standard");
		
		Classes twelth = new Classes();
		twelth.setClassName("Twelth standard");
		
		
		subjects.add(maths);
		subjects.add(physics);
		subjects.add(chemistry);
		
		twelth_subjects.add(twelth_physics);
		twelth_subjects.add(twelth_maths);
		twelth_subjects.add(twelth_chemistry);
		
		tenth_subjects.add(tenth_tamil);
		tenth_subjects.add(tenth_science);
		tenth_subjects.add(tenth_maths);
		
	
//		t1.setSubjects(subjects);
//		t2.setSubjects(subjects);
//		t3.setSubjects(subjects);
		
		teachers.add(t1);
		teachers.add(t2);
		teachers.add(t3);
		
		twelth_teachers.add(t1);
		twelth_teachers.add(t2);
		twelth_teachers.add(t3);
		
		tenth_teachers.add(t1);
		tenth_teachers.add(t2);
		tenth_teachers.add(t3);
		
		
		classes.add(eleventh);
		classes.add(tenth);
		classes.add(twelth);
		
		t1.setClasses(classes);
		t2.setClasses(classes);
		t3.setClasses(classes);
		
		maths.setClasses(classes);
		physics.setClasses(classes);
		chemistry.setClasses(classes);
		
		twelth_maths.setClasses(classes);
		twelth_physics.setClasses(classes);
		twelth_chemistry.setClasses(classes);
		
		tenth_maths.setClasses(classes);
		tenth_science.setClasses(classes);
		tenth_tamil.setClasses(classes);
		
		eleventh.setTeachers(teachers);
		eleventh.setSubjects(subjects);
		
		tenth.setTeachers(tenth_teachers);
		tenth.setSubjects(tenth_subjects);
		
		twelth.setTeachers(twelth_teachers);
		twelth.setSubjects(twelth_subjects);
		
		tenth_students.add(s1);
		tenth_students.add(s2);
		tenth_students.add(s3);
		tenth_students.add(s4);
		
		students.add(s5);
		students.add(s6);
		students.add(s7);
		
		twelth_students.add(s8);
		twelth_students.add(s9);
		twelth_students.add(s10);
		twelth_students.add(s10);
		
		eleventh.setStudents(students);
		twelth.setStudents(twelth_students);
		tenth.setStudents(tenth_students);
		
		for(Teacher t: eleventh.getTeachers()) {
			if(t.getTeacherName().equals("Malar")) {
				t.getSubjects().add(physics);
			}else if(t.getTeacherName().equals("Ashok")) {
				t.getSubjects().add(maths);
			}else {
				t.getSubjects().add(chemistry);
			}
		}
		
		for(Teacher t: twelth.getTeachers()) {
			if(t.getTeacherName().equalsIgnoreCase("malar")) {
				t.getSubjects().add(twelth_maths);
			}else if(t.getTeacherName().equals("Ashok")) {
				t.getSubjects().add(twelth_physics);
			}else {
				t.getSubjects().add(twelth_chemistry);
			}
		}
		
		for(Teacher t: tenth.getTeachers()) {
			if(t.getTeacherName().equalsIgnoreCase("malar")) {
				t.getSubjects().add(tenth_maths);
			}else if(t.getTeacherName().equals("Ashok")) {
				t.getSubjects().add(tenth_science);
			}else {
				t.getSubjects().add(tenth_tamil);
			}
		}
		
		
		HttpSession httpSession = request.getSession();
		
		httpSession.setAttribute("classes", classes);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		int i =0;
		for(Classes cl: classes) {
			i= (Integer)session.save(cl);
		}
		session.getTransaction().commit();
		
		if(i>0) {
			out.print("Record inserted");
		}else {
			out.print("Record insertion failed");
		}
		
	}
}








