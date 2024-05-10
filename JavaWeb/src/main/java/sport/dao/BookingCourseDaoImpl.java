package sport.dao;

import java.sql.*;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import sport.model.po.BookingCourse;
import room.dao.JdbcTemplateBuild;

import org.springframework.jdbc.core.JdbcTemplate;


public class BookingCourseDaoImpl implements BookingCourseDao {

	private JdbcTemplate jdbcTemplate = JdbcTemplateBuild.getInstance();

	@Override
	public BookingCourse findbyId(BookingCourseDao BookingCourseId) {
		String sql = "select * from bookingcourse where bookingcourseId = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookingCourse.class), BookingCourseId);
	}

	@Override
	public List<BookingCourse> findAll() {
		String sql = "select * from bookingcourse";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingCourse.class));
	}

	@Override
	public List<BookingCourse> findByUserName(String username) {
		String sql = "select * from bookingcourse where username = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingCourse.class), username);
	}

	@Override
	public int create(BookingCourse bookingCourse) {
		String sql = "insert into bookingcourse(bookingcourseId, sportClassId, username, createTime) values(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, bookingCourse.getBookingcourseId(), bookingCourse.getSportClassId(), bookingCourse.getUsername(), bookingCourse.getCreateTime());
	}

	@Override
	public int update(Integer BookingCourseId, BookingCourse bookingCourse) {
		String sql = "update bookingcourse set sportClassId = ? where bookingcourseId = ?";
		return jdbcTemplate.update(sql, bookingCourse.getSportClassId(), BookingCourseId);
	}

	@Override
	public int delete(Integer BookingCourseId) {
		String sql = "delete from bookingcourse where bookingcourseId = ?";
		return jdbcTemplate.update(sql, BookingCourseId);
	}





}
