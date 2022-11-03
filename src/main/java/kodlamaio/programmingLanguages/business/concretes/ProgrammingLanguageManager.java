package kodlamaio.programmingLanguages.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import kodlamaio.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.programmingLanguages.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return this.programmingLanguageRepository.getById(id);
	}
	
	@Override
	public ProgrammingLanguage getByName(String name) {
		return this.programmingLanguageRepository.getByName(name);
	}
	
	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getName() == null) {
			throw new Exception("Please type a programming language!");
		}else if(this.checkIfProgrammingLanguageExists(programmingLanguage.getName())) {
			throw new Exception("Programming language already exists!");
		}
		else {
			this.programmingLanguageRepository.add(programmingLanguage);
		}
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getName() == null) {
			throw new Exception("Please type a programming language!");
		}else {
			this.programmingLanguageRepository.update(programmingLanguage);
		}
	}

	@Override
	public void delete(int id) {
		this.programmingLanguageRepository.delete(id);
		
	}
	
	public boolean checkIfProgrammingLanguageExists(String name) {
		if(this.programmingLanguageRepository.getByName(name).getName() == null) {
			return false;
		}
		return true;
	}

	
	
	
	
	
	
}
