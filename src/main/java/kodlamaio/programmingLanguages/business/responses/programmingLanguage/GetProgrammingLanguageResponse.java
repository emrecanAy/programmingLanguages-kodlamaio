package kodlamaio.programmingLanguages.business.responses.programmingLanguage;

import java.util.List;

import kodlamaio.programmingLanguages.entities.dtos.GetAllSubTechnologiesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProgrammingLanguageResponse {

	private int id;
	private String name;
	private List<GetAllSubTechnologiesDto> subTechnologies;
	
}
