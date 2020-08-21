package com.zhaodp.aspect;

import com.zhaodp.base.result.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Controller参数校验自定义结果返回
 *
 * @Author zhaodp
 * @Date 2020-8-21
 */
@Aspect
@Component
public class ControllerAspect {

    @Around("execution(public * com.zhaodp..*Controller.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        Errors errors = null;
        Object[] args = pjp.getArgs();
        if (null != args && args.length != 0) {
            for (Object object : args) {
                if (object instanceof BindingResult) {
                    errors = (BindingResult) object;
                    break;
                }
            }
        }
        if (errors != null && errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            return R.error(R.VALID_EX_CODE, allErrors.get(0).getDefaultMessage());
        }
        return pjp.proceed();
    }

}
