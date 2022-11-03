package kodlamaio.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import kodlamaio.programmingLanguages.entities.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguageService.getAll();
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable() int id) {
		return this.programmingLanguageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		this.programmingLanguageService.add(programmingLanguage);
	}
	
	@PutMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		this.programmingLanguageService.update(programmingLanguage);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable() int id) {
		this.programmingLanguageService.delete(id);
	}
	
	
	
}
