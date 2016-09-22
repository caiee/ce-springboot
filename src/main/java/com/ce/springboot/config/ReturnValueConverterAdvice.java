package com.ce.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Component
@ControllerAdvice
public class ReturnValueConverterAdvice implements ResponseBodyAdvice {

    /**
     * 日志记录.
     */
    private Logger logger = LoggerFactory.getLogger(ReturnValueConverterAdvice.class);

    /**
     * @param returnType    returnType
     * @param converterType converterType
     * @return boolean
     */
    public final boolean supports(final MethodParameter returnType, final Class converterType) {
        return true;
    }

    /**
     * 处理返回字符串.
     *
     * @param response response
     * @param string   string
     * @return
     */
    private Void printRawString(final ServerHttpResponse response, final String string) {
        try {
            response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
            response.getBody().write(string.getBytes("US-ASCII"));
        } catch (Exception e) {
            logger.error("write raw string failed", e);
        }
        return null;
    }

    /**
     * 在返回前进行封装.
     *
     * @param body                  body
     * @param returnType            returnType
     * @param selectedContentType   selectedContentType
     * @param selectedConverterType selectedConverterType
     * @param request               request
     * @param response              response
     * @return Object
     */
    public final Object beforeBodyWrite(final Object body, final MethodParameter returnType, final MediaType selectedContentType, final Class selectedConverterType, final ServerHttpRequest request, final ServerHttpResponse response) {

        return body;
        /*if (null == body)
            return new ReturnValue(true, null);
        else if (body instanceof ReturnValue)
            return body;
        else if (body instanceof ErrorResult)
            return new ReturnValue(false, body);
        else if (body instanceof RawString)
            return printRawString(response, body.toString());
        else
            return new ReturnValue(true, body);*/
    }
}
