package com.ramumani.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramumani.model.InterestRate;

public interface InterestRateRepo extends JpaRepository<InterestRate, Long> {

	Optional<InterestRate> findByTenure(String tenure);

}
