package kodlamaio.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.programmingLanguages.business.abstracts.SubTechnologyService;
import kodlamaio.programmingLanguages.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import kodlamaio.programmingLanguages.business.responses.subTechnology.GetSubTechnologyResponse;
import kodlamaio.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.programmingLanguages.dataAccess.abstracts.SubTechnologyRepository;
import kodlamaio.programmingLanguages.entities.ProgrammingLanguage;
import kodlamaio.programmingLanguages.entities.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService{

	private SubTechnologyRepository subTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> subTechnologies = this.subTechnologyRepository.findAll();
		List<GetAllSubTechnologiesResponse> subTechnologiesResponse = new ArrayList<>();
		for(SubTechnology subTechnology : subTechnologies) {
			GetAllSubTechnologiesResponse responseItem = new GetAllSubTechnologiesResponse();
			responseItem.setId(subTechnology.getId());
			responseItem.setName(subTechnology.getName());
			responseItem.setLanguage(subTechnology.getProgrammingLanguage().getName());
			subTechnologiesResponse.add(responseItem);
		}
		return subTechnologiesResponse;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setName(createSubTechnologyRequest.getName());
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(createSubTechnologyRequest.getLanguageId()).get();
		subTechnology.setProgrammingLanguage(programmingLanguage);
		this.subTechnologyRepository.save(subTechnology);
		
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology = this.subTechnologyRepository.findById(updateSubTechnologyRequest.getId()).get();
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(updateSubTechnologyRequest.getProgrammingLanguageId()).get();
		subTechnology.setProgrammingLanguage(programmingLanguage);
		subTechnology.setName(updateSubTechnologyRequest.getName());
		this.subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		this.subTechnologyRepository.deleteById(deleteSubTechnologyRequest.getId());
	}

	@Override
	public GetSubTechnologyResponse getById(int id) {
		SubTechnology subTechnology = this.subTechnologyRepository.findById(id).get();
		GetSubTechnologyResponse getSubTechnologyResponse = new GetSubTechnologyResponse();
		getSubTechnologyResponse.setId(subTechnology.getId());
		getSubTechnologyResponse.setName(subTechnology.getName());
		getSubTechnologyResponse.setLanguage(subTechnology.getProgrammingLanguage().getName());
		return getSubTechnologyResponse;
	}

	@Override
	public GetSubTechnologyResponse findByName(String name) {
		SubTechnology subTechnology = this.subTechnologyRepository.findByName(name);
		GetSubTechnologyResponse getSubTechnologyResponse = new GetSubTechnologyResponse();
		getSubTechnologyResponse.setId(subTechnology.getId());
		getSubTechnologyResponse.setName(subTechnology.getName());
		getSubTechnologyResponse.setLanguage(subTechnology.getProgrammingLanguage().getName());
		return getSubTechnologyResponse;
	}

	
	
}
