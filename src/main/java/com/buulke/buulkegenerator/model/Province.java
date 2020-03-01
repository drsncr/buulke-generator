package com.buulke.buulkegenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("Province")
public class Province {
    private Integer id;
    private String name;
    private Region region;
    private List<Integer> cityIds;
    private List<Integer> neighbourIds;
}
