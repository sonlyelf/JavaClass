package sport.dao;

import java.sql.*;
import java.util.List;

import sport.model.po.SportClass;

public interface SportClassDao {
	SportClass findById(Integer sportClassId);
	List<SportClass>findAll();
	int create (SportClass sportClass);
	int update(SportClass sportClass);
	int delete(Integer sportClassId);
}

