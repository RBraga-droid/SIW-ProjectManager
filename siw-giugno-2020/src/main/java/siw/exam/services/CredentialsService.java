package siw.exam.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siw.exam.model.Credentials;
import siw.exam.repository.CredentialsRepository;

@Service
public class CredentialsService {
	
	@Autowired
	private CredentialsRepository credentialsRepository;
	
	@Transactional
	public Credentials getCredentials(long id) {
		Optional <Credentials> result = this.credentialsRepository.findById(id);
		return result.orElse(null);
		
	}
	
	public Credentials getCredentials(String username) {
		Optional <Credentials> result = this.credentialsRepository.findByUserName(username);
		return result.orElse(null);
	}
	
	public Credentials saveCredentials (Credentials credentials) {
		credentials.setRole(Credentials.DEFAULT_ROLE);
		return this.credentialsRepository.save(credentials);
	}
	
}
