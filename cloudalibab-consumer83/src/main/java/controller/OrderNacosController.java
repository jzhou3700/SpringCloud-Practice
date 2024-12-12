package controller;


import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PayFeignApi payFeignApi;
    @Resource
//    private PayFeignSentinelApi payFeignSentinelApi;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/consumer/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id)
    {
        String result = restTemplate.getForObject(serviceUrl+"/pay/nacos/"+id,String.class);
        return "调用结果"+ "\t"+result ;
    }

    @GetMapping("/consumer/pay/nacos/get/{orderNo}")
    ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo)
    {
        return payFeignApi.getPay(11);
//        return payFeignSentinelApi.getPayByOrderNo(orderNo);
    }
}
