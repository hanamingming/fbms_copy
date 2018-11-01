package com.fenbi.fbms;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.fenbi.fbms.entity.Course;
import com.fenbi.fbms.entity.Lesson;
import com.fenbi.fbms.entity.LessonVo;
import com.fenbi.fbms.mapper.CourseMapper;

public class AppTest3 {
	
	/**
	 * 查询课程同时，级联查询每门课程包含的所有课时
	 */
	@Test
	public void testSelectCoursesByTitleLikeUserMapperInterface() {
		InputStream is = AppTest3.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
		List<Course> courses = mapper.selectCoursesByTitleLike("Java");
		sqlSession.close();
	}
	
	/**
	 * 查询课程同时，级联查询每门课程包含的所有课时·
	 */
	public void testUpdateCoursesUseIfTag() {
		InputStream is = AppTest3.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		Course course = new Course();
		course.setId(49);
		course.setDescription("中文描述");
		sqlSession.update("update", course);
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 查询课程同时，级联查询每门课程包含的所有课时
	 */
	public void testSelectCoursesByTitleLike() {
		InputStream is = AppTest3.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		List<Course> courses = sqlSession.selectList("selectCoursesByTitleLike", "Java");
		sqlSession.close();
	}
	
	/**
	 * 查询课程同时，级联查询每门课程包含的所有课时
	 */
	public void testSelectAllLessonVosJoinTeacher() {
		InputStream is = AppTest3.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		List<LessonVo> lessonVos=sqlSession.selectList("selectAllLessonsJoinTeacher");
		sqlSession.close();
	}
	
	/**
	 * 查询课程同时，级联查询每门课程包含的所有课时
	 */
	public void testSelectAllLessonsJoinTeacher() {
		InputStream is = AppTest3.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		List<Lesson> lessons=sqlSession.selectList("selectAllLessonsJoinTeacher");
		sqlSession.close();
	}
	
	/**
	 * 查询课程同时，级联查询每门课程包含的所有课时
	 */
	public void testSelectAllCoursesJoinLesson() {
		InputStream is = AppTest3.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		List<Course> courses=sqlSession.selectList("selectAllCoursesJoinLesson");
		sqlSession.close();
	}
}






