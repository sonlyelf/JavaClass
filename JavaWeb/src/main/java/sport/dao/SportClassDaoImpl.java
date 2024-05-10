package sport.dao;

import java.sql.*;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import sport.model.po.SportClass;
import room.dao.JdbcTemplateBuild;

import org.springframework.jdbc.core.JdbcTemplate;

public class SportClassDaoImpl implements SportClassDao {

	private JdbcTemplate jdbcTemplate = JdbcTemplateBuild.getInstance()	;	

	@Override
	public SportClass findById(Integer sportclassId) {
		String sql ="select sportclass_id ,sportclass_name from SportClass where sportclass_id =?";
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SportClass.class),sportclassId);
		}catch (DataAccessException e) {
			return null;
		}
	}
		

	@Override
	public List<SportClass> findAll() {
		String sql ="select * from SportClass";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SportClass.class));
	}

	@Override
	public int create(SportClass sportClass) {
		String sql = "insert into sportClass(sportclass_id,sportclass_name,start_Date,end_Date)values(?,?,?,?)";
		return jdbcTemplate.update(sql ,sportClass.getSportclassId(),sportClass.getSportclassName(),sportClass.getStartDate(),sportClass.getEndDate());
	}

	@Override
	public int update(SportClass sportClass) {
		String sql = "update sportClass set sportclass_name=? , start_Date=? ,end_Date = ? where sportclass_id = ?";
		return jdbcTemplate.update(sql ,sportClass.getSportclassName(),sportClass.getStartDate(),sportClass.getEndDate(),sportClass.getSportclassId());
	}

	@Override
	public int delete(Integer sportClassId) {
		String sql = "delete from sportClass where sportclass_id = ?";
		return jdbcTemplate.update(sql ,sportClassId);
	}

}
