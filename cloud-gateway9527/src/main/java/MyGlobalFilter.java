import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    public static final String BEGIN_VISIT_TIME = "beginVisitTime";
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //先记录访问接口时间
        exchange.getAttributes().put(BEGIN_VISIT_TIME,System.currentTimeMillis());
        log.info("全局过滤器MyGlobalFilter,order:{}",getOrder());
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long beginVisitTime = (Long) exchange.getAttributes().get(BEGIN_VISIT_TIME);
            if(beginVisitTime!=null){
                log.info("访问接口主机："+exchange.getRequest().getURI().getHost());
                log.info("访问接口路径："+exchange.getRequest().getURI().getPath());
                log.info("访问接口路径："+exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口耗时："+(System.currentTimeMillis()-beginVisitTime)  +"ms");
                log.info("====================================");
                System.out.println();
            }
        }));
    }

}
