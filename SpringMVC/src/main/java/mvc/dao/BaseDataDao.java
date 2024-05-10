package mvc.dao;

import java.util.List;

import mvc.model.po.Education;
import mvc.model.po.Gender;
import mvc.model.po.Interest;

public interface BaseDataDao {
	List<Education> findAllEducations(); //查詢所有教育程度
	Education getEducationById(Integer id); //查詢教育程度
	
	List<Gender> findAllGenderes(); //查詢所有性別
	Gender getGenderById(Integer id); //查詢性別
	
	
	List<Interest> findAllInterest();  //查詢所有興趣
	Interest getInterestById(Integer id);   //查詢興趣
	
	int addInterest(Integer userId, Integer interestId);  //新增使用者興趣
	int deleteInterestByUserId(Integer userId);    //刪除指定使用者興趣
	
}
