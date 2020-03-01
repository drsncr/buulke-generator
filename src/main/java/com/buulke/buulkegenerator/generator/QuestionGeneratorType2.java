package com.buulke.buulkegenerator.generator;

import com.buulke.buulkegenerator.model.Question;

import java.util.Arrays;

public class QuestionGeneratorType2 implements IQuestionGeneratorType {

    @Override
    public Question generateQuestion() {
        //TODO implement real generation

        Question question = new Question();
        question.setText("Aşağıdaki ilçelerden hangisi İstanbul ilinin bir ilçesi değildir?");
        question.setOptions(Arrays.asList("Tuzla", "Çekmeköy", "Didim", "Avcılar"));
        question.setRightOption("Didim");
        return question;
    }
}
