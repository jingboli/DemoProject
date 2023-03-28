package cc.ljb.mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cc.ljb.mysql.mapper")
public class MySqldxflApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySqldxflApplication.class, args);
    }

}
