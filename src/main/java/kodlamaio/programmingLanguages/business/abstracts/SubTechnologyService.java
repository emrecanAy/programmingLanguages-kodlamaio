package kodlamaio.programmingLanguages.business.abstracts;

import java.util.List;

import kodlamaio.programmingLanguages.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import kodlamaio.programmingLanguages.business.responses.subTechnology.GetSubTechnologyResponse;


public interface SubTechnologyService {
	List<GetAllSubTechnologiesResponse> getAll();
	GetSubTechnologyResponse getById(int id);
	GetSubTechnologyResponse findByName(String name);
	void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception;
	void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest);
}
