package com.example.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.config.RabbitConfig;
import com.example.dto.RechargeProducerDTO;

@Component
public class RechargeListener {

	@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
	public void processRecharge(RechargeProducerDTO dto) throws InterruptedException {
		System.out.println("Received recharge request");
		System.out.println("Processing recharge for: " + dto.getMobileNumber());
		Thread.sleep(5000);
		System.out.println("Recharge completed for: " + dto.getMobileNumber());
	}
}