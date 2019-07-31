package com.hcl.productdb.mq;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

import com.hcl.productdb.dto.ProductVersionDto;


public class ProductSender {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
 
	@Autowired
	private Queue queue;
 
	public void sendMessage(List<ProductVersionDto> productList) {
                // This will put text message to queue
		this.jmsMessagingTemplate.convertAndSend(this.queue, productList);
		System.out.println("Message has been put to queue by sender");
	}
}
