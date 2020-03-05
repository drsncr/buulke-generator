package com.buulke.buulkegenerator.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitMqConfiguration {

    @Autowired
    private Environment env;

    @Bean
    TopicExchange exchange() {
        String topicExchangeName = env.getProperty("rabbitmq.topicExchangeName");
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Queue queue() {
        String queueName = env.getProperty("rabbitmq.queueName");
        return new Queue(queueName, false);
    }

    @Bean
    Binding binding(TopicExchange exchange, Queue queue) {
        String routingKey = env.getProperty("rabbitmq.routingKey");
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
