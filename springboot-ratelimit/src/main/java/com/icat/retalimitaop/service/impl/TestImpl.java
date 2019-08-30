package com.icat.retalimitaop.service.impl;

import com.icat.retalimitaop.annotation.RateLimit;
import com.icat.retalimitaop.service.Test;

import com.icat.retalimitaop.util.MyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class TestImpl implements Test {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @RateLimit(limitNum = 1)
    public MyResult getResults() {
        log.info("调用了方法getResults");
        return MyResult.OK("调用了方法",null);
    }

    @RateLimit(limitNum = 10)
    public MyResult getResultTwo() {
        log.info("调用了方法getResultTwo");
        return MyResult.OK("调用了方法getResultTwo",null);
    }
}
