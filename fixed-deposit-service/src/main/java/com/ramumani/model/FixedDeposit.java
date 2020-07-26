package com.ramumani.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private int userno;
	private String tenure;
	private BigDecimal initialamount;
	private BigDecimal maturityamount;
	private BigDecimal rate;

}
