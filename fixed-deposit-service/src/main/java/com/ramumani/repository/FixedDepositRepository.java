package com.ramumani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramumani.model.FixedDeposit;

public interface FixedDepositRepository extends JpaRepository<FixedDeposit, Long> {

}
