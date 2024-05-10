package sport.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.List;

import sport.dao.SportClassDao;
import sport.dao.SportClassDaoImpl;
import sport.model.po.SportClass;


public class SportClassService {
	
	private SportClassDao sportClassDao = new SportClassDaoImpl();
	
	public boolean addSportClass(Integer sportclassId, String sportclassName,Date startDate,Date endDate) { //String startDate, String startDate,String endDate) {
		
		SportClass sportClass = new SportClass();
		sportClass.setSportclassId(sportclassId);
		
		sportClass.setSportclassName(sportclassName);
	
		sportClass.setStartDate(startDate);
		sportClass.setEndDate(endDate);
		
		return sportClassDao.create(sportClass) > 0;
		
	}
	
	public SportClass getSportClass(Integer sportclassId) {
		return sportClassDao.findById(sportclassId);
		
	}
	public List<SportClass> getAllSportClass(){
		return sportClassDao.findAll();
	}
	
		
	public boolean updateSportClass(Integer sportclassId, String sportclassName , Date startDate, Date endDate) {
		SportClass sportClass = new SportClass();
		sportClass.setSportclassId(sportclassId);
		sportClass.setSportclassName(sportclassName);
		sportClass.setStartDate(startDate);
		sportClass.setEndDate(endDate);
		return sportClassDao.update(sportClass ) > 0;
	}
	
	public boolean deleteSportClass(Integer sportclassId) {
		return sportClassDao.delete(sportclassId)>0;
	
}
}
