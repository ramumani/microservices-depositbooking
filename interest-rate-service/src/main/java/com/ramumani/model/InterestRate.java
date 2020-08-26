package com.ramumani.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "interestrate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Tenure is required")
	private String tenure;
	
	@NotNull(message = "Rate is required")
	private BigDecimal rate;

}
