package com.fenbi.fbms.mapper;

import java.util.List;

import com.fenbi.fbms.entity.Course;

/**
 * 该接口与CourseMapper.xml对应
 */
public interface CourseMapper {
	
	/**
	 * 通过id查询课程
	 * @param id
	 * @return
	 */
	public Course selectById(int id);
	
	/**
	 * 该方法与xml配置文件中的selectCoursesByTitleLike标签相匹配
	 * @param title
	 * @return
	 */
	public List<Course> selectCoursesByTitleLike(String title);
	
}
