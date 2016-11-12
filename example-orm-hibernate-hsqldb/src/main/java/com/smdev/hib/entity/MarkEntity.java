package com.smdev.hib.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

import com.smdev.hib.core.CrudEntity;

/**
 * @author Ireth
 */
@Entity
@DynamicUpdate
@Table(name = "marks", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class MarkEntity implements CrudEntity {

	/** */
	private static final long serialVersionUID = -4593497558595353195L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_ID", unique = false, nullable = false)
	private CourseEntity course;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "mark", unique = false, nullable = false, length = 1)
	private char mark;

	@Column(name = "mark_date", unique = false, nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date markDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_ID", unique = false, nullable = false)
	private StudentEntity student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_ID", unique = false, nullable = false)
	private TeacherEntity teacher;

	/**
	 * @return the course
	 */
	public CourseEntity getCourse() {
		return this.course;
	}

	/**
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the mark
	 */
	public char getMark() {
		return this.mark;
	}

	/**
	 * @return the markDate
	 */
	public Date getMarkDate() {
		return this.markDate;
	}

	/**
	 * @return the student
	 */
	public StudentEntity getStudent() {
		return this.student;
	}

	/**
	 * @return the teacher
	 */
	public TeacherEntity getTeacher() {
		return this.teacher;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param mark
	 *            the mark to set
	 */
	public void setMark(char mark) {
		this.mark = mark;
	}

	/**
	 * @param markDate
	 *            the markDate to set
	 */
	public void setMarkDate(Date markDate) {
		this.markDate = markDate;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	/**
	 * @param teacher
	 *            the teacher to set
	 */
	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

}
