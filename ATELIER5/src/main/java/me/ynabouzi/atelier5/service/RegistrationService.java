package me.ynabouzi.atelier5.service;

import me.ynabouzi.atelier5.models.Registration;
import me.ynabouzi.atelier5.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
	private final RegistrationRepository registrationRepository;

	@Autowired
	public RegistrationService(RegistrationRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	public void addNewRegistration(Registration registration){
		registrationRepository.save(registration);
	}

	public RegistrationRepository getRegistrationRepository() {
		return registrationRepository;
	}
}