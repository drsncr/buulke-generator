package com.buulke.buulkegenerator.generator;

import com.buulke.buulkegenerator.model.Question;

import java.util.Arrays;

public class QuestionGeneratorType4 implements IQuestionGeneratorType {

    @Override
    public Question generateQuestion() {
        //TODO implement real generation

        Question question = new Question();
        question.setText("Bolvadin hangi ilin bir ilçesidir?");
        question.setOptions(Arrays.asList("Afyon", "Aksaray", "Ağrı", "Artvin"));
        question.setRightOption("Afyon");
        return question;
    }
}
