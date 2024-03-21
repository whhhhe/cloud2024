package com.zmy.cloud.mygateway;

import io.netty.util.collection.CharCollections;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
//*
// 会员等级大于等于5方可访问*/
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {
    public MyRoutePredicateFactory() {
        super(MyRoutePredicateFactory.Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String vipLevel = serverWebExchange.getRequest().getHeaders().getFirst("vipLevel");
                return vipLevel != null && Integer.parseInt(vipLevel) >= 5;
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("vipLevel");
    }

    @Validated
    public static class Config{
        @NotNull
        @Setter
        @Getter
        private String vipLevel; //会员等级
    }
}
