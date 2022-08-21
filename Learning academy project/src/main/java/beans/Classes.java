package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cls_gen")
	@SequenceGenerator(name="cls_gen", sequenceName = "cls_seq")
	private int classId;
	
	@Column(length = 20)
	private String className;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="class_subject", joinColumns = {@JoinColumn(name = "classId")}, inverseJoinColumns = {@JoinColumn(name = "subjectId")})
	Set<Subject> subjects = new HashSet<Subject>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="class_teacher", joinColumns = {@JoinColumn(name = "classId")}, inverseJoinColumns = {@JoinColumn(name = "teacherId")})
	Set<Teacher> teachers = new HashSet<Teacher>();


	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="class_student", joinColumns = {@JoinColumn(name = "classId")}, inverseJoinColumns = {@JoinColumn(name = "studentId")})
	Set<Student> students = new HashSet<Student>();
	
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
