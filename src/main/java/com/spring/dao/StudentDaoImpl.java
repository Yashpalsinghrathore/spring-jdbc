package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.modal.Student;

@Component("dao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		
	    int res = jdbcTemplate.update("insert into student values(?,?,?)",student.getId(),student.getName(),student.getCity());
		
		return res;
	}

	public int change(Student student) {
		
		String sql = "update student set name=?,address=? where id=?";
		
		int res = this.jdbcTemplate.update(sql,student.getName(),student.getCity(),student.getId());
		
		return res;
		
	}

	public int delete(int studentId) {
		
		String sql = "delete from student where id = ?";
		
		int res = this.jdbcTemplate.update(sql,studentId);
		
		return res;
	}

	public Student getStudent(int studentId) {
		
		String sql = "select * from student where id = ?";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		Student student = this.jdbcTemplate.queryForObject(sql, rowMapper,studentId);
		
		return student ;
	}

	public List<Student> getAllStudent() {
		
		String sql = "select * from student";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		List<Student> student = this.jdbcTemplate.query(sql,rowMapper);
		
		return student;
	}

}
