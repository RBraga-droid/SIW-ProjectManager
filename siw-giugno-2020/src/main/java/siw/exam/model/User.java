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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="users")
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable=false)
	private String username;
	
	@Column (nullable=false)
	private String password;
	
	@Column (nullable=false)
	private String firstName;
	
	@Column (nullable=false)
	private String lastName;
	
	private LocalDate creationDate;
	
	
	/*L'utente può essere proprietario di uno o più progetti e ogni progetto ha un proprietario:
	 *la relazione è denominata owner; 
	 *cascadeType REMOVE: qualora eliminassimo il
	 *proprietario del progetto elimineremo anche il progetto stesso;
	 *fetch Lazy: se vogliamo caricare un utente, non necessariamente ci interessano i progetti di cui è proprietario. 
	 */
	@OneToMany (mappedBy="owner", cascade = {CascadeType.REMOVE}, fetch=FetchType.LAZY)
	private List <Project> ownedProjects;
	
	/*L'utente può avere visibilità su uno o più progetti e ogni progetto può essere visibile da più utenti:
	 *la relazione è denominata members; 
	 *fetch Lazy: se vogliamo caricare un utente, non necessariamente ci interessano i progetti di cui ha visibilità. 
	 */
	@ManyToMany (mappedBy="members", fetch=FetchType.LAZY)
	private List <Project> visibleProjects;
			
	//costruttore base
	public User() {
		
	}

	//metodi getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<Project> getOwnedProjects() {
		return ownedProjects;
	}

	public void setOwnedProjects(List<Project> ownedProjects) {
		this.ownedProjects = ownedProjects;
	}

	public List<Project> getVisibleProjects() {
		return visibleProjects;
	}

	public void setVisibleProjects(List<Project> visibleProjects) {
		this.visibleProjects = visibleProjects;
	}

	//metodo toString: stampa a video un utente
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", creationDate=" + creationDate + ", ownedProjects=" + ownedProjects
				+ ", visibleProjects=" + visibleProjects + "]";
	}

}