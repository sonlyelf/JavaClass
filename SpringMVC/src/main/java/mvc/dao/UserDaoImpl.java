package mvc.dao;

import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.jdbc.Sql;

import mvc.model.po.User;

public class UserDaoImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private BaseDataDao baseDataDao;
	
	@Override
	public int addUser(User user) {
		String sql = "indert into user (name , age, birth, resume ,education_id , gender_id )values=(?,?,?,?,?,?)";
//		return	jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getBirth(),user.getResume(),user.getEducationId(),user.getGenderId());
	    
		//自動將 user 物件的屬性值給 SQL 參數（?) 使用
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
	   
		//KeyHolder
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		//KeyHolder,new String[]{"id"} 將主鍵id欄位所自動生成的資料放入keyHolder中
		namedParameterJdbcTemplate.update(sql, params,keyHolder,new String[]{"id"});
	    
	    
	    int userId =keyHolder.getKey().intValue(); //最新新增紀錄的 user id
	    
	    //新增該 user 的興趣紀錄
	    for (Integer integerId : user.getInterestIds()) {
		    baseDataDao.addInterest(integerId, integerId);
	    }
	    		return userId;
	}

	@Override
	public int updateUser(Integer id, User user) {
		//更新使用者
		String sql = "update user set name=?,age=?,birth=?,resume=?,education_id=?,gender_id=? where id=?";
		int rowcount = jdbcTemplate.update(sql, user.getName(),user.getAge(),user.getBirth(),
											user.getResume(),user.getEducationId(),user.getGenderId(),id);
		
		
		//更新使用者的興趣（table user_interest）
		//1.先刪除該使用者的興趣
		baseDataDao.deleteInterestByUserId(id);
		
		//2.再新增該使用者的興趣
		 for (Integer integerId : user.getInterestIds()) {
			    baseDataDao.addInterest(integerId, integerId);
		 }
		
		//3.最後更新使用者的興趣
		return rowcount;
		
	}

	@Override
	public int deleteUser(Integer userId) {
		//1.先刪除 user_interest
		baseDataDao.deleteInterestByUserId(userId);
		//2.再刪除 user
		String sql = "delete from user where id = ?";
		return jdbcTemplate.update(sql,userId);
	}

	@Override
	public User getUserById(Integer userId) {
		String sql = "select id,name , age, birth, resume ,education_id , gender_id  from user where id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),userId);
	}

	@Override
	public List<User> findAllUsers() {
		String sql = "select id,name , age, birth, resume ,education_id , gender_id  from user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}
	
	

}
