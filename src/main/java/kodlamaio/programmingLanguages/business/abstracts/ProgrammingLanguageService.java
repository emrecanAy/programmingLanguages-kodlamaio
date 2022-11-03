package kodlamaio.programmingLanguages.business.abstracts;

import java.util.List;

import kodlamaio.programmingLanguages.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	ProgrammingLanguage getByName(String name);
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(ProgrammingLanguage programmingLanguage) throws Exception;
	void delete(int id);
	
}
