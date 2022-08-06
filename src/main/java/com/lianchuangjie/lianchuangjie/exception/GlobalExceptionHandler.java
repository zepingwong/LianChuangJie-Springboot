package com.lianchuangjie.lianchuangjie.exception;

import com.lianchuangjie.lianchuangjie.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @date 2022-07-22
 * @description 全局异常处理器
 */
@Slf4j
// 对Controller增强,并返回json格式字符串
@RestControllerAdvice
public class GlobalExceptionHandler {

     // 生产环境名称
    @Value("${ENV_PROD}")
    private String ENV_PROD;
    /**
     * 当前环境
     */
    @Value("${spring.profiles.active}")
    private String profile;
    /**
     * @description 字段验证异常
     */
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public Result<Object> exception(IllegalArgumentException e,HttpServletRequest request) {
        log.error("request error!! method:{} uri:{}", request.getMethod(), request.getRequestURI());
        String message = getExceptionDetail(e);
        return Result.error(100, message);
    }
    /**
     * Assert异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> exception(BusinessException e,HttpServletRequest request) {
        log.error("request error!! method:{} uri:{}", request.getMethod(), request.getRequestURI());
        return Result.error(e.getResponseEnum().getCode(), e.getMessage());
    }
    /**
     * 获取代码报错详细位置信息
     */
    public String getExceptionDetail(Exception e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getClass()).append(System.getProperty("line.separator"));
        stringBuilder.append(e.getLocalizedMessage()).append(System.getProperty("line.separator"));
        StackTraceElement[] arr = e.getStackTrace();
        for (StackTraceElement stackTraceElement : arr) {
            stringBuilder.append(stackTraceElement.toString()).append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }

    /**
     * 自定义异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseException.class)
    public Result<Object> handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);
        //return new ErrorResponse(e.getResponseEnum().getCode(), getMessage(e));
        return Result.error(e.getResponseEnum().getCode(), e.getMessage());
    }

    /**
     * Controller上一层相关异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public Result<Object> handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        int code = ResponseEnum.FAILURE.getCode();
        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如404.
            Result.error(code, e.getMessage());
        }
        return Result.error(code, e.getMessage());
    }


    /**
     * 参数绑定异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    public Result<String> handleBindException(BindException e) {
        log.error("参数绑定校验异常", e);
        return Result.error(100, e.getBindingResult().toString());
    }

    /**
     * @description 处理请求参数格式错误 @RequestBody上使用@Valid 实体上使用@NotNull等，验证失败后抛出的异常是ConstraintViolationException异常
     * @param e 异常信息
     * @return 异常信息
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Object> handleValidException(ConstraintViolationException e) {
        log.error("参数绑定校验异常", e);
        if (ENV_PROD.equals(profile)) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
            return Result.error(ResponseEnum.VALID_ERROR.getCode(), message);
        } else {
            return Result.error(ResponseEnum.VALID_ERROR.getCode(), e.getLocalizedMessage());
        }
    }

    /**
     * 未定义异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = Exception.class)
    public Result<String> handleException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        System.out.println(e.getClass());

        log.error("request error!! method:{} uri:{}", request.getMethod(), request.getRequestURI());
        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            String message = e.getMessage();
            return Result.error(ResponseEnum.VALID_ERROR.getCode(), message);
        }
        return Result.error(ResponseEnum.VALID_ERROR.getCode(), e.getMessage());
    }
}
