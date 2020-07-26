package com.ramumani.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ramumani.model.FixedDeposit;

@Service
public class FixedDepositService {

	public BigDecimal calculateMaturityAmount(FixedDeposit fixedDeposit) {
		BigDecimal lbdInitialAmount = fixedDeposit.getInitialamount();
		BigDecimal divisor = new BigDecimal(100);
		BigDecimal lbdMaturityAmount = (lbdInitialAmount.multiply(fixedDeposit.getRate())).divide(divisor);
		lbdMaturityAmount = lbdInitialAmount.add(lbdMaturityAmount);
		return lbdMaturityAmount;

	}

}
