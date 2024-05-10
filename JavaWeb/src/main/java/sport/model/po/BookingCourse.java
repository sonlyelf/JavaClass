package sport.model.po;

import java.util.Date;

import sport.dao.BookingCourseDao;
import lombok.Data;


@Data
public class BookingCourse  {
	
		private Integer bookingcourseId;
		private Integer sportClassId;
		private String sportclassName;
		private String  username;
		private  Date createTime;

}
