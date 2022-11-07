package kodlamaio.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import kodlamaio.programmingLanguages.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlamaio.programmingLanguages.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlamaio.programmingLanguages.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlamaio.programmingLanguages.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlamaio.programmingLanguages.business.responses.programmingLanguage.GetProgrammingLanguageResponse;
import kodlamaio.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.programmingLanguages.dataAccess.abstracts.SubTechnologyRepository;
import kodlamaio.programmingLanguages.entities.ProgrammingLanguage;
import kodlamaio.programmingLanguages.entities.dtos.GetAllSubTechnologiesDto;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private SubTechnologyRepository subTechnologyRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, SubTechnologyRepository subTechnologyRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.subTechnologyRepository = subTechnologyRepository;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<>();
		
		for(ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			List<GetAllSubTechnologiesDto> subTechnologiesResponse = this.subTechnologyRepository.findAllByProgrammingLanguageId(programmingLanguage.getId());
			responseItem.setSubTechnologies(subTechnologiesResponse);
			programmingLanguagesResponse.add(responseItem);
		}
		return programmingLanguagesResponse;
	}

	@Override
	public GetProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(id).get();
		GetProgrammingLanguageResponse getProgrammingLanguageResponse = new GetProgrammingLanguageResponse();
		getProgrammingLanguageResponse.setId(programmingLanguage.getId());
		getProgrammingLanguageResponse.setName(programmingLanguage.getName());
		List<GetAllSubTechnologiesDto> subTechnologies = this.subTechnologyRepository.findAllByProgrammingLanguageId(id);
		getProgrammingLanguageResponse.setSubTechnologies(subTechnologies);
		return getProgrammingLanguageResponse;
	}
	
	@Override
	public GetProgrammingLanguageResponse findByName(String name){
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findByName(name);
		GetProgrammingLanguageResponse getProgrammingLanguageResponse = new GetProgrammingLanguageResponse();
		getProgrammingLanguageResponse.setId(programmingLanguage.getId());
		getProgrammingLanguageResponse.setName(programmingLanguage.getName());
		List<GetAllSubTechnologiesDto> subTechnologies = this.subTechnologyRepository.findAllByProgrammingLanguageId(programmingLanguage.getId());
		getProgrammingLanguageResponse.setSubTechnologies(subTechnologies);
		return getProgrammingLanguageResponse;
		
	}
	
	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if(createProgrammingLanguageRequest.getName() == null) {
			throw new Exception("Please type a programming language!");
		}else if(this.checkIfProgrammingLanguageExists(createProgrammingLanguageRequest.getName())) {
			throw new Exception("Programming language already exists!");
		}
		else {
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguageRequest.getName());
			this.programmingLanguageRepository.save(programmingLanguage);
		}
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		if(updateProgrammingLanguageRequest.getName() == null) {
			throw new Exception("Please type a programming language!");
		}else {
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
			programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
			this.programmingLanguageRepository.save(programmingLanguage);
		}
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		this.programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
		
	}
	
	public boolean checkIfProgrammingLanguageExists(String name) {
		if(this.programmingLanguageRepository.findByName(name) == null) {
			return false;
		}
		return true;
	}

	
	
	
	
	
	
}
