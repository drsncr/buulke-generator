package com.buulke.buulkegenerator.service;

import com.buulke.buulkegenerator.component.QuestionGenerator;
import com.buulke.buulkegenerator.model.Question;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionGenerator questionGenerator;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    public void generateQuestion(){
        Question question = questionGenerator.getRandomQuestion();
        String exchangeName = env.getProperty("rabbitmq.topicExchangeName");
        String routingName = "question.generator";
        rabbitTemplate.convertAndSend(exchangeName, routingName, question);
    }
}
