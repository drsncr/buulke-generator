package com.buulke.buulkegenerator.generator;

import com.buulke.buulkegenerator.model.Question;

import java.util.Arrays;

public class QuestionGeneratorType3 implements IQuestionGeneratorType {

    @Override
    public Question generateQuestion() {
        //TODO implement real generation

        Question question = new Question();
        question.setText("Aşağıdaki illerden hangisi Aydın iline komşu değildir?");
        question.setOptions(Arrays.asList("Muğla", "Denizli", "Manisa", "Uşak"));
        question.setRightOption("Uşak");
        return question;
    }
}
