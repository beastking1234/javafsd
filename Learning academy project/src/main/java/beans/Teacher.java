package beans;

import java.util.HashSet;
import java.util.Set;

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
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teach_gen")
	@SequenceGenerator(name="teach_gen", sequenceName = "teach_seq")
	private int teacherId;
	
	private String teacherName;
	
	@ManyToMany(mappedBy = "teachers")
	Set<Classes> classes = new HashSet<Classes>();
	
	@OneToMany
	@JoinTable(name="subject_teacher", joinColumns = {@JoinColumn(name = "teacherId")}, inverseJoinColumns = {@JoinColumn(name = "subjectId")})
	Set<Subject> subjects = new HashSet<Subject>();

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
