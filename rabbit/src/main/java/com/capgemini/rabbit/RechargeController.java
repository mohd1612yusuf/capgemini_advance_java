package com.capgemini.rabbit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recharge")
public class RechargeController {

	private final RechargeService service;

	public RechargeController(RechargeService service) {
		this.service = service;
	}

	@PostMapping
	public String doRecharge(@RequestBody RechargeProducerDTO dto) {
		return service.serviceRecharge(dto);
	}
}