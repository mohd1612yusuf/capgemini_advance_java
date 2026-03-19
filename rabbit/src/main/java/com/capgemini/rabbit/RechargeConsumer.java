package com.capgemini.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RechargeConsumer {

	@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
	public void processRecharge(RechargeProducerDTO dto) throws InterruptedException {

		System.out.println("Message received from queue");
		System.out.println("Recharge processing for mobile " + dto.getMobilenumber());

		Thread.sleep(5000);

		System.out.println("Recharge done " + dto.getMobilenumber());
	}
}