package com.baomidou.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: yyg
 * @Date: 2019/12/26 09:59
 * @Description:
 */
@SpringBootApplication
//指定spring扫描的内容 (如果包下没有对应的包会报错)
@ComponentScan(basePackages = {"com.baomidou.test.*"}) //全局扫描
@MapperScan(basePackages={"com.baomidou.test.**.store.mapper"})  //mapper扫描
public class MASApplication {
    public static void main(String[] args){
        SpringApplication.run(MASApplication.class,args);
        System.out.println("MASApplication 启动成功。。。");
    }
}
