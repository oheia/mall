package com.oheia.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.oheia.mall.mbg.mapper")
public class MyBatisConfig {
}
