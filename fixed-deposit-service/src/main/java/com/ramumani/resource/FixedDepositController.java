package com.ramumani.resource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ramumani.dto.InterestRate;
import com.ramumani.feign.client.InterestRateFeignClient;
import com.ramumani.model.FixedDeposit;
import com.ramumani.repository.FixedDepositRepository;
import com.ramumani.service.FixedDepositService;

@RestController
@RequestMapping(path = "/fixeddepositapi")
public class FixedDepositController {

	Logger logger = LoggerFactory.getLogger(FixedDepositController.class);

	@Autowired
	FixedDepositRepository fixedDepositRepository;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	InterestRateFeignClient interestRateFeignClient;
	
	@Value("${FD.INTEREST_RATE_URL}")
	private String gsINTEREST_RATE_URL; 

	@PostMapping("/fixeddeposits")
	public FixedDeposit saveFixedDeposit(@Valid @RequestBody FixedDeposit fixedDeposit) {
		FixedDepositService fixedDepositService = new FixedDepositService();
		logger.debug("gsINTEREST_RATE_URL:" + gsINTEREST_RATE_URL);
		
		  //logger.debug("before calling Rest Template");
		  //InterestRate interestRate = restTemplate .getForObject(gsINTEREST_RATE_URL +fixedDeposit.getTenure(), InterestRate.class); 
		  //BigDecimal lbdInterestRate = interestRate.getRate();
		 
		logger.debug("before calling Feign Client");
		Optional<InterestRate> lOptInterestRate = interestRateFeignClient.getInterestRates(fixedDeposit.getTenure());
		BigDecimal lbdInterestRate = lOptInterestRate.get().getRate();
		lbdInterestRate = lbdInterestRate.setScale(2, RoundingMode.HALF_EVEN);
		logger.debug("lbdInterestRate:" + lbdInterestRate);
		fixedDeposit.setRate(lbdInterestRate);
		BigDecimal lbdMaturityAmount = fixedDepositService.calculateMaturityAmount(fixedDeposit);
		logger.debug("lbdMaturityAmount:" + lbdMaturityAmount);
		fixedDeposit.setMaturityamount(lbdMaturityAmount);
		logger.debug(fixedDeposit.toString());
		return fixedDepositRepository.save(fixedDeposit);

	}
	
	@GetMapping(path = "/hello")
	public String getTest() {
		return "From FD API!!!";
		
	}

}
