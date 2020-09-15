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
import lombok.ToString;

@Entity(name = "fixeddeposit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FixedDeposit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "userno is required")
	private int userno;
	@NotNull(message = "userno is required")
	private String tenure;
	@NotNull(message = "initialamount is required")
	private BigDecimal initialamount;
	@NotNull(message = "maturityamount is required")
	private BigDecimal maturityamount;
	@NotNull(message = "rate is required")
	private BigDecimal rate;

}
