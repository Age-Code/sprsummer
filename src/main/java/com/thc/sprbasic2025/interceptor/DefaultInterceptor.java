package com.thc.sprbasic2025.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DefaultInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 컨트롤러 집입 전에 호출되는 메서드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle");
        //logger.info("TestToken : " + request.getHeader("TestToken"));
        logger.info("AccessToken : " + request.getHeader("Authorization"));

        //request.setAttribute("tempValue", "10101");
        //response.setHeader("tempTest", "01010");
        
        // request의 Attreibute에 공간 만들기
        request.setAttribute("reqUserId", null);

        return true;
    }

    // 컨트롤러 실행 후에 호출되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        logger.info("postHandle");
    }

    // 모든 것을 마친 후 실행되는 메서드
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion");
    }
}
