package com.buulke.buulkegenerator.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @Autowired
    QuestionService questionService;

    @RabbitListener(queues = "${rabbitmq.orderQueueName}")
    public void rabbitMqListener(String questionCount) {
        int quantity = Integer.valueOf(questionCount);
        for (int i = 0; i < quantity; i++) {
            System.out.println("questionService.generateQuestion() is called");
            questionService.generateQuestion();
        }
    }
}
