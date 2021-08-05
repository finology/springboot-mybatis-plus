package gy.finolo.springbootmybatisplus.exception;

import gy.finolo.springbootmybatisplus.common.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @description: 全局异常处理
 * @author: Simon
 * @date: 2021-08-03 13:22
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMissingServletRequestParameter(ex, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(HttpServletResponse response, Exception e) {

        if (e instanceof ConstraintViolationException) {
            ConstraintViolation<?> violation = ((ConstraintViolationException) e).getConstraintViolations().iterator().next();
            String message = violation.getMessage();
            String[] codeAndMessage = message.split("=");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Response.fail(Integer.valueOf(codeAndMessage[0]), codeAndMessage[1]);
        }

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return Response.fail(9999, e.getMessage());
    }

    @ExceptionHandler(AppException.class)
    public Response appExceptionHandler(HttpServletResponse response, Exception e) {
        AppException exception = (AppException) e;
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return Response.fail(exception.getCode(), exception.getMessage());
    }
}
