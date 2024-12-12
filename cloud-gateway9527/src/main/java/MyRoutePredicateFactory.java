import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config>{

    public static class Config{
        @Setter
        @Getter
        @NotEmpty
        private String userType;

    }
    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if (userType == null){
                    return false;
                }
                if(userType.equalsIgnoreCase(config.getUserType())){
                    return true;
                }
                return false;
            }

        };
    }
}
