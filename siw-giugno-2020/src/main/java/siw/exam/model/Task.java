package siw.exam.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable=false)
	private String name;
	
	private String description;
	
	private LocalDate creationDate;
	
	/*
	* Ogni task può essere associato ad uno o più tag e ogni tag può essere
	* associato ad uno o più task
	* la relazione è denominata taskTag
	* fetch LAZY: qualora necessario visualizzare i tag verranno caricati 
	* cascade REMOVE: non ha senso avere dei tag non associati ad alcun task
	  */
	@ManyToMany (fetch=FetchType.LAZY, cascade = {CascadeType.REMOVE})
	private List <Tag> taskTag;
	
	public Task() {
	}
	
	//inizializza con la data odierna prima di un Persist
	@PrePersist
	protected void onPersist() {
		creationDate= LocalDate.now();
		}

	//metodi getters and setters
	
	public Long getId() {
		return id;
	}
		
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
			
	public List<Tag> getTaskTag() {
		return taskTag;
	}

	public void setTaskTag(List<Tag> taskTag) {
		this.taskTag = taskTag;
	}

	//metodo toString: stampa a video le info di Task
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", creationDate=" + creationDate
				+ "]";
	}
	
	
	
	

}
