package com.ramumani.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramumani.model.InterestRate;
import com.ramumani.repo.InterestRateRepo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/interestrateapi")
@Slf4j
@RefreshScope
public class InterestRateController {
	
	@Autowired
	InterestRateRepo interestRateRepo;
	
	@Value("${testrecord:defualt from code}")
	String lsData;

	@GetMapping(path = "/{tenure}")
	public Optional<InterestRate> getInterestRates(@PathVariable("tenure") String tenure) {
		log.debug("tenure:"+tenure);
		return interestRateRepo.findByTenure(tenure);
		
	}
	
	@PostMapping(path = "/interestrates")
	public InterestRate saveInterestRate(@RequestBody InterestRate interestRate) {
		 return interestRateRepo.save(interestRate);
	}
	
	@GetMapping(path = "/hello")
	public String getTest() {
		return "From interest rate!!! "+lsData;
		
	}
}
