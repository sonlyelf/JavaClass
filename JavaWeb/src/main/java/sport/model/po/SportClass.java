package sport.model.po;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportClass {

		private Integer sportclassId;
		private String  sportclassName;
		private  Date StartDate;
		private  Date EndDate;

	}



