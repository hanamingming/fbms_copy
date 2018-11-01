package com.fenbi.fbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fenbi.fbms.entity.Course;
import com.fenbi.fbms.mapper.CourseMapper;
import com.fenbi.fbms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Course> selectCoursesByTitleLike(String title) {
		List<Course> list = courseMapper.selectCoursesByTitleLike(title);
		return list;
	}

	@Override
	public Course findById(int id) {
		return courseMapper.selectById(id);
	}

}
