package mvc.user.model.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id; // 序號
	@NotEmpty(message = "姓名不可空白")
//	@Size(min = 2, max = 50, message = "姓名長度必須介於 2 到 50 之間")
	private String name; // 姓名
	
	@NotNull(message = "年齡不可空白")
	@Range(min = 18, max = 150, message = "年齡必須介於 18 到 150 之間")
	private Integer age; // 年齡
	
	@NotNull(message = "生日不可空白")
	@Past(message = "日期不可大於今日日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 日期格式
	private Date birth; // 生日
	
	@Size( max = 1000, message = "履歷長度不可超過1000字")
	private String resume; // 履歷
	
	@NotNull(message = "請選擇教育程度")
	private Integer educationId; // 教育程度 id
	
	@NotNull(message = "請選擇性別")
	private Integer genderId; // 性別 id
	
	@Size(min=1, message = "請選擇至少一項興趣")
	private Integer[] interestIds; // 興趣 ids
	
}