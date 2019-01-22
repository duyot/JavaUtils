package com.utils.common;


import es.moki.ratelimitj.core.limiter.request.RequestLimitRule;
import es.moki.ratelimitj.core.limiter.request.RequestRateLimiter;
import es.moki.ratelimitj.core.limiter.request.RequestRateLimiterFactory;
import es.moki.ratelimitj.redis.request.RedisClusterRateLimiterFactory;
import io.lettuce.core.cluster.RedisClusterClient;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

public class RedisReqIdDAO {


    public static void invalidateExpiredReqId(){
        System.out.println("Running");
    }

    public static void main(String[] args) {
        RequestRateLimiterFactory factory = new RedisClusterRateLimiterFactory(RedisClusterClient.create("redis://localhost"));

        Set<RequestLimitRule> rules = Collections.singleton(RequestLimitRule.of(Duration.ofMinutes(1), 50)); // 50 request per minute, per key
        RequestRateLimiter requestRateLimiter = factory.getInstance(rules);

        boolean overLimit = requestRateLimiter.overLimitWhenIncremented("ip:127.0.0.2");
    }
}
