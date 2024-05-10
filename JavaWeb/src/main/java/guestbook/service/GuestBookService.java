package guestbook.service;

import java.util.List;

import guestbook.model.GuestBook;

//Controller -> Service ->DAO
public interface GuestBookService {

	boolean add(String username, String content);
	GuestBook getById(Integer id); //	單筆查詢
	List<GuestBook> queryAll();  //	多筆查詢
	boolean updateName(Integer id,String username);  //修改使用者名稱
	boolean updateContent( Integer id,String content);  //修改留言內容
	boolean removeById(Integer id);  //刪除
	
}
