package gy.finolo.springbootmybatisplus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 各种异步方式请求
 * @author: Simon
 * @date: 2020-07-30 11:37
 */
@Slf4j
@RestController
public class AsyncReqController {

    @GetMapping("/servletReq/{timeout}")
    public void servletReq(ServletRequest request, ServletResponse response, @PathVariable Long timeout) {
        // 开启异步
        AsyncContext asyncContext = request.startAsync();

        // 设置监听器, 可设置开始、完成、异常、超时等事件的回调处理
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                log.info("completed...");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                log.info("timeout...");
//                asyncContext.complete();
//                AsyncContext context = event.getAsyncContext();
                asyncContext.getResponse().setCharacterEncoding("utf-8");
                asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                asyncContext.getResponse().getWriter().println("Web Response, 超时");
                asyncContext.complete();
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                log.info("error...");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                log.info("started...");
            }
        });

        // 设置超时时间
        asyncContext.setTimeout(timeout);

        // 执行逻辑
        asyncContext.start(() -> {
            log.info("biz logic, {}", Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                asyncContext.getResponse().setCharacterEncoding("utf-8");
                asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                asyncContext.getResponse().getWriter().println("Web Response, 请求返回");

                // 异步请求完成通知
                log.info("A");
                asyncContext.complete();
                log.info("B");
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        log.info("main thread {} ends...", Thread.currentThread().getName());
    }

}
