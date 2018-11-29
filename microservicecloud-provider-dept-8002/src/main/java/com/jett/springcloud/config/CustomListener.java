package com.jett.springcloud.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
@Slf4j
public class CustomListener implements ServletRequestListener {
    private static AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("监听销毁!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        int cnt=atomicInteger.addAndGet(1);
        log.info("当前仿问人数:"+cnt);
    }
}
