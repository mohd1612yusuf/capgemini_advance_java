package com.example.serv;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.config.RabbitConfig;
import com.example.dto.RechargeProducerDTO;

@Service
public class RechargeService {
	private final RabbitTemplate rabbitTemplate;
	private final Set<String> set = ConcurrentHashMap.newKeySet();
	public RechargeService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public String sendRechargeRequest(RechargeProducerDTO dto) {
		if (!set.contains(dto.getMobileNumber())) {
			set.add(dto.getMobileNumber());
			rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, dto);
			return "message has been sent to broker";
		}
		return "only one time you can request";
	}
}