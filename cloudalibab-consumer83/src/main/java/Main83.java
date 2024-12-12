import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients//(basePackages = "com.jay.cloud")
public class Main83{
    public static void main(String[] args) {
        SpringApplication.run(Main83.class,args);
    }
}
