package com.hcl.productdb.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import com.hcl.productdb.mq.ProductReciver;
import com.hcl.productdb.mq.ProductSender;

@Configuration
public class ActiveMQConfiguration {

	@Value("${spring.activemq.broker-url}")
    private String activeMqUrl="tcp://localhost:61616";
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("product.queue");
	}
	
	 @Bean
	    public ActiveMQConnectionFactory connectionFatory(){
	        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	        factory.setBrokerURL(activeMqUrl);
	        factory.setUserName("admin");
	        factory.setPassword("admin");
	        factory.setTrustAllPackages(true);
	        return factory;
	    }

	    @Bean
	    public JmsTemplate jmsTemplate(){
	        return new JmsTemplate(connectionFatory());
	    }
	    
	    @Bean
	    public ProductSender sender() {
	      return new ProductSender();
	    }
	    
	    @Bean
	    public ProductReciver reciver() {
	    	return new ProductReciver();
	    }
}
