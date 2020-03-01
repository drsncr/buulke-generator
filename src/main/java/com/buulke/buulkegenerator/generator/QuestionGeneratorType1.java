package com.buulke.buulkegenerator.generator;

import com.buulke.buulkegenerator.model.Question;

import java.util.Arrays;

public class QuestionGeneratorType1 implements IQuestionGeneratorType {

    @Override
    public Question generateQuestion() {
        //TODO implement real generation

        Question question = new Question();
        question.setText("Aşağıdaki ilçelerden hangisi Konya ilinin bir ilçesidir?");
        question.setOptions(Arrays.asList("Of", "Seydişehir", "Söke", "Geyve"));
        question.setRightOption("Seydişehir");
        return question;
    }
}
