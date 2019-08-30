package com.icat.retalimitaop.util;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitUtil {

    private ConcurrentHashMap<String,RateLimiter> map = new ConcurrentHashMap<>();

    public  RateLimiter getRateLimiter(Integer limit,String methodName){
        RateLimiter rateLimiter=null;
        if(map.containsKey(methodName)){
            rateLimiter=map.get(methodName);
        }else {
            map.put(methodName,RateLimiter.create(limit));
            rateLimiter=map.get(methodName);
        }
        return rateLimiter;
    }


}
