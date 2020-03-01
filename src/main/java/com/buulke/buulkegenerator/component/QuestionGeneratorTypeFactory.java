package com.buulke.buulkegenerator.component;

import com.buulke.buulkegenerator.generator.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuestionGeneratorTypeFactory {

    final Map<Integer, IQuestionGeneratorType> generators = new HashMap<>();

    public QuestionGeneratorTypeFactory(){
        initialize();
    }

    public void initialize(){
        generators.put(1, new QuestionGeneratorType1());
        generators.put(2, new QuestionGeneratorType2());
        generators.put(3, new QuestionGeneratorType3());
        generators.put(4, new QuestionGeneratorType4());
    }

    public IQuestionGeneratorType getQuestionGenerator(Integer key){
        IQuestionGeneratorType questionGenerator = null;
        if(generators.containsKey(key)){
            questionGenerator = generators.get(key);
        }
        return questionGenerator;
    }

    public Integer getQuestionTypeCount(){
        return generators.size();
    }
}
