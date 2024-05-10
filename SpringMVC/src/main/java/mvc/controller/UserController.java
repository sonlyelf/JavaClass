package mvc.controller;

import java.util.List;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.model.po.User;
import mvc.service.UserService;


/**
 *定義ＵＲＬ服務
 *--------------------------------------------------------------------------
 *Method   |  URI      | Description
 *--------------------------------------------------------------------------
 * GET     | /user     |取得所有使用者資料
 * POST    | /user/1   |根據userId 取得單筆資料
 * POST    | /user     |新增使用者資料，會自動夾帶User 物件資料上來
 *  PUT    | /user/1   |根據指定userId 的使用者資料 ，會自動夾帶要修改的User 物件資料上來
 *  DELETE | /user/1   |刪除指定userId 的使用者紀錄
 *  --------------------------------------------------------------------------
 *  URL 範例 ：GET http://localhost:8080/SpringMVC/mvc/user
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@ResponseBody
	public String queryAllUsers() {
		List<User> users = userService.findUsers();
		return users.toString();
	}
	
	
	@GetMapping("/{userId}")
	@ResponseBody
	public String getUser(@PathVariable Integer userId) {
		User user = userService.getUser(userId);
		return user.toString();
	}
	
	@PostMapping
	@ResponseBody
	public String createUser(User user) {
		Boolean success = userService.addUser(user);
		return success.toString();
	}
	
	@PutMapping("/{userId}")
	@ResponseBody
	public String updateUser(@PathVariable("userId") Integer userId, User user) {
		Boolean success = userService.updateUser(userId, user);
		return success.toString();
	
	}
	
	
	@DeleteMapping("/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") Integer userId) {
		Boolean success = userService.deleteUser(userId);
		return "delete"+success;
	}
	
	
	

}
