package com.capgemini.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RechargeService {

	private final RabbitTemplate rabbitTemplate;

	public RechargeService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public String serviceRecharge(RechargeProducerDTO dto) {

		rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, dto);

		return "Message has been sent to broker";
	}
}