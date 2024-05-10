package sport.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sport.dao.BookingCourseDaoImpl;
import sport.model.po.BookingCourse;




public class BookingCourseService {
	
	private BookingCourseDaoImpl bookingCourseDao = new BookingCourseDaoImpl();
	
	public boolean addBookingCourse(Integer BookingCourseId, Integer sportClassId, String sportclassName ,String  username,Date crateTime) {
		BookingCourse bookingCourse  = new BookingCourse ();
		bookingCourse  .setBookingcourseId(BookingCourseId);
		bookingCourse  .setSportClassId(sportClassId);
		bookingCourse  .setSportclassName(sportclassName);
		bookingCourse .setUsername(username);
		bookingCourse .setCreateTime(crateTime);
		return bookingCourseDao.create(bookingCourse)> 0;
	}

	public boolean deleteBookingCourse(Integer BookingCourseId) {
		return bookingCourseDao.delete(BookingCourseId) > 0;
	}
		
	

	public List<BookingCourse> findAllBookingCourse() {
		return bookingCourseDao.findAll();
	}
	
	public boolean updateBookingCourse(Integer BookingCourseId, Integer sportClassId,  String  username, Date createTime) {
		BookingCourse bookingCourse = new BookingCourse();
		bookingCourse.setBookingcourseId(BookingCourseId);
		bookingCourse.setSportClassId(sportClassId);
		bookingCourse.setUsername(username);
		bookingCourse.setCreateTime(createTime);
		
		return bookingCourseDao.update(BookingCourseId, bookingCourse) > 0;
	}


}

