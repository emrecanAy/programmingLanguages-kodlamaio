package kodlamaio.programmingLanguages.business.responses.subTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSubTechnologyResponse {

	private int id;
	private String name;
	private String language;
	
}
