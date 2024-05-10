package sport.dao;

import java.util.List;

import sport.model.po.BookingCourse;

public interface BookingCourseDao {

	BookingCourse findbyId (BookingCourseDao BookingCourseId);
	List<BookingCourse> findAll();
	List<BookingCourse> findByUserName(String username);
	
	int create(BookingCourse bookingCourse);
	int update(Integer BookingCourseId, BookingCourse bookingCourse);
	int delete(Integer BookingCourseId);
	

}
