//package com.utilities;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//
///**
// * Created by mariannefeng on 6/20/16.
// */
//@Component
//public class TestFilter implements Filter {
//
//    private static Logger logger = LoggerFactory.getLogger(TestFilter.class);
//
//    @Override
//    public void destroy() {}
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {}
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//            throws IOException, ServletException {
//        logger.info("This is testing whether or not a second filter will be picked up automatically.");
//        chain.doFilter(req, res);
//    }
//}