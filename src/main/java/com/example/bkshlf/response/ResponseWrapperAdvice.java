package com.example.bkshlf.response;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object>
{

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse)
    {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (methodParameter.getMethod().isAnnotationPresent(ResponseKey.class)) {
            HttpServletRequest servletRequest = requestAttributes.getRequest();
            HandlerMethod handlerMethod = (HandlerMethod) servletRequest.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
            ResponseKey responseKeyAnnotation = handlerMethod.getMethodAnnotation(ResponseKey.class);
            ResponseWrapper wrapper = new ResponseWrapper();
            wrapper.setKey(responseKeyAnnotation.value());

            if (responseKeyAnnotation != null) {
                Map<String, Object> responseBody = new LinkedHashMap<>();
                responseBody.put(responseKeyAnnotation.value(), body);
                return responseBody;
            }
        }
        return body;
    }
}

