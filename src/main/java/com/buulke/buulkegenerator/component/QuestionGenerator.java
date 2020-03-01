package com.buulke.buulkegenerator.component;

import com.buulke.buulkegenerator.generator.IQuestionGeneratorType;
import com.buulke.buulkegenerator.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class QuestionGenerator {

    @Autowired
    QuestionGeneratorTypeFactory questionGeneratorTypeFactory;

    public Question getRandomQuestion(){
        IQuestionGeneratorType questionGenerator = getQuestionGenerator();
        return questionGenerator.generateQuestion();
    }

    public IQuestionGeneratorType getQuestionGenerator(){
        Random random = new Random();
        int sizeOfQuestionGenerator = questionGeneratorTypeFactory.getQuestionTypeCount();
        int questionTypeId = random.nextInt(sizeOfQuestionGenerator) + 1;
        System.out.println("Question Type Id ==> " + questionTypeId);
        return questionGeneratorTypeFactory.getQuestionGenerator(questionTypeId);
    }
}
