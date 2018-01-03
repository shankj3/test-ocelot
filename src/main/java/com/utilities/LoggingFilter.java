package com.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * A logging filter that will intercept ALL HTTP Requests and
 * logs the IP address, request URL, request type, and time of Request before passing
 * the request forward to be handled by the controller
 *
 * Created by mariannefeng on 6/14/16.
 */
@Component
public class LoggingFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig config) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String ipAddress = request.getRemoteAddr();
        String requestURI = request.getRequestURI();
        String requestType = request.getMethod();
        logger.info("IP "+ ipAddress + " requested " + requestType + " at " + requestURI);
        chain.doFilter(req, res);
    }
}