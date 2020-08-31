package gy.finolo.springbootmybatisplus.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 文件消息国际化
 * @author: Simon
 * @date: 2020-08-31 10:43
 */
@Component
public class MessageSourceHandler {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String messageKey) {
        return messageSource.getMessage(messageKey, null, RequestContextUtils.getLocale(request));
    }
}
