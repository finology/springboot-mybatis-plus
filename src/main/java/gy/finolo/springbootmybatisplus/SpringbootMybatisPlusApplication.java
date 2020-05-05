package gy.finolo.springbootmybatisplus;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
@MapperScan("gy.finolo.springbootmybatisplus.dao")
@Slf4j
public class SpringbootMybatisPlusApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("datasource: {}", dataSource);
    }
}
