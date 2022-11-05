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

import kodlamaio.programmingLanguages.business.abstracts.SubTechnologyService;
import kodlamaio.programmingLanguages.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlamaio.programmingLanguages.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import kodlamaio.programmingLanguages.business.responses.subTechnology.GetSubTechnologyResponse;

@RestController
@RequestMapping("/api/subtechnologies")
public class SubTechnologiesController {

	private SubTechnologyService subTechnologyService;

	@Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse> getAll(){
		return this.subTechnologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetSubTechnologyResponse getById(@PathVariable int id) {
		return this.subTechnologyService.getById(id);
	}
	
	@GetMapping
	public GetSubTechnologyResponse getByName(@RequestParam(name = "name") String name) {
		return this.subTechnologyService.findByName(name);
	}
	
	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		this.subTechnologyService.update(updateSubTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		this.subTechnologyService.delete(deleteSubTechnologyRequest);
	}
	
	
}
