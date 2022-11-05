package kodlamaio.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import kodlamaio.programmingLanguages.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlamaio.programmingLanguages.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlamaio.programmingLanguages.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlamaio.programmingLanguages.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlamaio.programmingLanguages.business.responses.programmingLanguage.GetProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return this.programmingLanguageService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetProgrammingLanguageResponse getById(@PathVariable int id) {
		return this.programmingLanguageService.getById(id);
	}
	
	@GetMapping
	public GetProgrammingLanguageResponse getByName(@RequestParam(value = "name") String name) {
		return this.programmingLanguageService.findByName(name);
	}
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		this.programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}
	
	
	
}
