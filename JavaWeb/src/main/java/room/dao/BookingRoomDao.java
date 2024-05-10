package room.dao;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.xalan.xsltc.compiler.sym;

import room.model.dto.BookingRoomCount;
import room.model.po.BookingRoom;

public interface BookingRoomDao {
	BookingRoom findById(Integer bookingId);
	List<BookingRoom> findAll();
	List<BookingRoom> findByUserId(Integer userId);
	List<BookingRoomCount> getBookingRoomCounts();
	
	int create(BookingRoom bookingRoom);
	int update(Integer bookingId, BookingRoom bookingRoom);
	int delete(Integer bookingId);

}

