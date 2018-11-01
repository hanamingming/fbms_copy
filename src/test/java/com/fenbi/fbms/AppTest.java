package com.fenbi.fbms;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.fenbi.fbms.entity.Course;
import com.fenbi.fbms.entity.Lesson;

/**
 * 测试方法
 */
public class AppTest {

	/**
	 * 测试mybatis天机数据  添加课时
	 */
	@Test
	public void testInsertLesson() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		Lesson lesson = new Lesson(0, 49, 3, "李老师的呵呵呵", 
				new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()));
		sqlSession.insert("com.fenbi.fbms.mapper.LessonMapper.insert", lesson);
		sqlSession.commit();
		sqlSession.close();
	}

	/**
	 * 测试mybatis查询数据  使用resultMap标签封装结果集
	 */
	public void testSelectAllUseResultMap() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		List<Course> courses = sqlSession.selectList("selectAllUseResultMap");
		sqlSession.close();
	}
	
	/**
	 * 测试mybatis查询数据  通过id查询课程
	 */
	public void testSelectCourseById() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		Course course = sqlSession.selectOne("selectById", 49);
		sqlSession.close();
	}
	
	/**
	 * 测试mybatis查询数据
	 */
	public void testSelectAllCourse() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		List<Course> course = sqlSession.selectList("selectAll");
		sqlSession.close();
	}
	
	/**
	 * 测试mybatis添加数据
	 */
	public void testDeleteCourse() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		sqlSession.delete("delete", 50);
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 测试mybatis添加数据
	 */
	public void testUpdateCourse() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		// 准备好数据
		Course course = new Course(0, 4, "高境的美好人生", "一言难尽！", 9.9, 0, 1, new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 10, 10);
		// 第一个参数是mapper配置文件中update标签的id属性值 ，第二个参数是需要传递的参数
		sqlSession.update("update", course);
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	/**
	 * 测试mybatis添加数据
	 */
	public void testInsertCourse() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		// 准备好数据
		Course course = new Course(0, 4, "高境的美好人生", "不错的课程", 9.9, 0, 1, new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 10, 10);
		// 第一个参数是mapper配置文件中insert标签的id属性值 ，第二个参数是需要传递的参数
		sqlSession.insert("insert", course);
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	/**
	 * 测试mybatis获取数据库连接
	 */
	public void testMybatis() {
		InputStream is = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = fac.openSession();
		Connection conn1 = sqlSession.getConnection();
		Connection conn2 = sqlSession.getConnection();
		Connection conn3 = sqlSession.getConnection();
		Connection conn4 = sqlSession.getConnection();
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
		System.out.println(conn4);
		sqlSession.close();
	}

}
