package com.oheia.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务配置
 */
@Configuration
@EnableScheduling //配置于此或者 Application上都可以
public class SpringTaskConfig {
}
