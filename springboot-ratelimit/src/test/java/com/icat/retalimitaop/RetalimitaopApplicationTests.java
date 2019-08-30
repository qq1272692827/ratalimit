package com.icat.retalimitaop;

import com.icat.retalimitaop.service.impl.TestImpl;
import com.icat.retalimitaop.util.MyResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetalimitaopApplicationTests {

    @Autowired
    private TestImpl testImpl;

    private CountDownLatch countDownLatch = new CountDownLatch(10);

    @Test
    public void contextLoads() {
        //myResult results = testImpl.getResults();
      ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0 ;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        MyResult results = testImpl.getResults();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            countDownLatch.countDown();
        }
        executorService.shutdown();
    }

}
