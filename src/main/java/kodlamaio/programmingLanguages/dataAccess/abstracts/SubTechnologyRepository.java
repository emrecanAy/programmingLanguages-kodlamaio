package kodlamaio.programmingLanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.programmingLanguages.entities.SubTechnology;

@Repository
public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer>{
	SubTechnology findByName(String name);
}
