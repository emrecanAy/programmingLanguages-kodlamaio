package kodlamaio.programmingLanguages.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlamaio.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.programmingLanguages.entities.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageDao implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
	public InMemoryProgrammingLanguageDao() {
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
	}
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id-1);
	}
	
	@Override
	public ProgrammingLanguage getByName(String name) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		for(ProgrammingLanguage p : programmingLanguages) {
			if(p.getName().equalsIgnoreCase(name)) {
				programmingLanguage = p;
				return programmingLanguage;
			}
		}
		return programmingLanguage;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.set(programmingLanguage.getId()-1, programmingLanguage);
	}

	@Override
	public void delete(int id) {
		programmingLanguages.remove(id-1);
	}

	

	
	
}
