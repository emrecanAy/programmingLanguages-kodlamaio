package kodlamaio.programmingLanguages.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.programmingLanguages.entities.SubTechnology;
import kodlamaio.programmingLanguages.entities.dtos.GetAllSubTechnologiesDto;

@Repository
public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer>{
	SubTechnology findByName(String name);
	
	@Query("Select new kodlamaio.programmingLanguages.entities.dtos.GetAllSubTechnologiesDto(s.id, s.name) From SubTechnology s WHERE programmingLanguage.id=:id")
	List<GetAllSubTechnologiesDto> findAllByProgrammingLanguageId(int id);
}
