package kodlamaio.programmingLanguages.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "programming_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","subTechnologies"})
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;	
	
	//@OneToMany(mappedBy = "programmingLanguage", fetch = FetchType.LAZY, targetEntity = SubTechnology.class, cascade = CascadeType.ALL)
	//private List<SubTechnology> subTechnologies;
	
	@OneToMany(mappedBy = "programmingLanguage")
	private List<SubTechnology> subTechnologies;
	
}
