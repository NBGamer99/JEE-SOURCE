package me.ynabouzi.atelier5.repository;

import me.ynabouzi.atelier5.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
