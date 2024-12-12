import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan("com.jay.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope
public class Main8002 {

    public static void main(String[] args) {
        System.out.println("支付微服务模块启动成功");
        SpringApplication.run(Main8002.class, args);
    }
}
