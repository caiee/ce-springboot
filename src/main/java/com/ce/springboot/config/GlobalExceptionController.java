package com.ce.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Global exception controller.
 * <p>
 * Handles all exceptions, if the exception have a response status,
 * set the HTTP status to that, else set the HTTP status to 500.
 * <p>
 * Error message displays only if the response status presents,
 * having the first non-empty value of following:
 * <ol>
 * <li>Response status reason</li>
 * <li>Localized message of exception</li>
 * <li>"Unknown error"</li>
 * </ol>
 * <p>
 * This handler also log every exception the generate 5XX error.
 */
@Component
@ControllerAdvice
public class GlobalExceptionController {

    /**
     * 日志记录类.
     */
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    /**
     * 异常处理类.
     *
     * @param e Exception
     * @return ErrorResult
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ErrorResult handleException(HttpServletRequest request, final Exception e) {
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = "服务器开了小差,请稍后重试.";

        ResponseStatus status = e.getClass().getAnnotation(ResponseStatus.class);
        if (status != null) {
            code = status.value().value();

            if (!StringUtils.isEmpty(status.reason())) {
                message = status.reason();
            } else if (!StringUtils.isEmpty(e.getLocalizedMessage())) {
                message = e.getLocalizedMessage();
            }
        }

        if (code >= HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            StringBuilder messageBuilder = new StringBuilder("Unhandled exception in request:\n");
            messageBuilder.append(request.getMethod());
            messageBuilder.append(" ");
            messageBuilder.append(request.getRequestURI());
            messageBuilder.append("\nHeader:");
            toIterable(request::getHeaderNames).forEach(name -> {
                messageBuilder.append("\n");
                String value = request.getHeader(name);
                messageBuilder.append(name);
                messageBuilder.append(": ");
                messageBuilder.append(value);
            });
            messageBuilder.append("\n");
            if (request.getParameterMap().size() > 0) {
                StringBuilder parameters = getRequestParameters(request);
                messageBuilder.append(parameters);
            }
            logger.error(messageBuilder.toString(), e);
        }

        return new ErrorResult(code, message);
    }

    private StringBuilder getRequestParameters(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder("请求参数为:");
        stringBuilder.append("\n");
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> {
            stringBuilder.append(k);
            stringBuilder.append(": ");
            stringBuilder.append(Arrays.toString(v));
            stringBuilder.append("\n");
        });
        return stringBuilder;
    }

    private <T> Iterable<T> toIterable(Supplier<Enumeration<T>> enumerationSupplier) {
        return () -> CollectionUtils.toIterator(enumerationSupplier.get());
    }
}
