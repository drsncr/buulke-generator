package com.buulke.buulkegenerator.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("City")
public class City {
    private Integer id;
    private String name;
    private Integer provinceId;
    private boolean isCenterCity;
}
