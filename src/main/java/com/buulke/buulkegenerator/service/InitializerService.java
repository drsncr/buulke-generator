package com.buulke.buulkegenerator.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.buulke.buulkegenerator.model.City;
import com.buulke.buulkegenerator.model.Province;
import com.buulke.buulkegenerator.model.QuestionType;
import com.buulke.buulkegenerator.repository.CityRepository;
import com.buulke.buulkegenerator.repository.ProvinceRepository;
import com.buulke.buulkegenerator.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class InitializerService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Autowired
    Environment env;

    @Autowired
    ObjectMapper objectMapper;

    private static final int EMPTY_REPOSITORY = 0;

    public void initializeRedisDatabase() throws IOException {
        initializeProvinceDatabase();
        initializeCityDatabase();
        initializeQuestionTypeDatabase();
    }

    private void initializeProvinceDatabase() throws IOException {
        if(provinceRepository.count() == EMPTY_REPOSITORY) {
            String fileLocation = env.getProperty("files.province.path");
            List<Province> provinceList = objectMapper.readValue(new File(fileLocation), new TypeReference<List<Province>>() {});
            provinceRepository.saveAll(provinceList);
        }
    }

    private void initializeCityDatabase() throws IOException {
        if(cityRepository.count() == EMPTY_REPOSITORY) {
            String fileLocation = env.getProperty("files.city.path");
            List<City> cityList = objectMapper.readValue(new File(fileLocation), new TypeReference<List<City>>() {});
            cityRepository.saveAll(cityList);
        }
    }

    private void initializeQuestionTypeDatabase() throws IOException {
        if(questionTypeRepository.count() == EMPTY_REPOSITORY) {
            String fileLocation = env.getProperty("files.questionType.path");
            List<QuestionType> questionTypeList = objectMapper.readValue(new File(fileLocation), new TypeReference<List<QuestionType>>() {});
            questionTypeRepository.saveAll(questionTypeList);
        }
    }
}
