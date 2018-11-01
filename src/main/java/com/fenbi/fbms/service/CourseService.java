package com.fenbi.fbms.service;

import java.util.List;

import com.fenbi.fbms.entity.Course;

public interface CourseService {
	
	/**
	 * 通过id获取Course对象
	 * @param id
	 * @return
	 */
	public Course findById(int id);
	
	/**
	 * 查询所有课程业务
	 * @return
	 */
	public List<Course> selectCoursesByTitleLike(String title);
	
}
