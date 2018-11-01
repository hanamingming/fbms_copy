package com.fenbi.fbms.entity;

/**
 * 当前类用于封装查询出来的课时相关的所有信息
 */
public class LessonVo {
	private Lesson lesson;
	private Teacher teacher;

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
