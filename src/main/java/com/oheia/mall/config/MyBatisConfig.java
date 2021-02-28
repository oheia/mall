package com.oheia.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.oheia.mall.mbg.mapper","com.oheia.mall.dao"})
public class MyBatisConfig {
}
