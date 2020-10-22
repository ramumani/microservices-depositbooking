package com.ramumani.feign.client;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ramumani.dto.InterestRate;

@FeignClient(url = "${FD.INTEREST_RATE_FEIGN_URL}", name = "INTEREST-RATE-CLIENT")
public interface InterestRateFeignClient {

	@GetMapping(path = "/{tenure}")
	public Optional<InterestRate> getInterestRates(@Valid @PathVariable("tenure") String tenure);

}
