package com;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import com.utilities.LoggingFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Basic Unit Test for the LoggingFilter class
 *
 *
 * Created by mariannefeng on 6/14/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoggingFilterTest {

    private LoggingFilter loggingFilter;

    @Mock
    private Appender mockAppender;
    @Captor
    private ArgumentCaptor<LoggingEvent> captorLoggingEvent;

    @Before
    public void setup() {
        loggingFilter = new LoggingFilter();
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.addAppender(mockAppender);
        root.setLevel(Level.INFO);
    }

    @Test
    public void testLoggingFilter() throws IOException, ServletException {
        // create the objects to be mocked
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        // mock the getRemoteAddr() response
        when(httpServletRequest.getRemoteAddr()).thenReturn("111.111.111.111");
        when(httpServletRequest.getRequestURI()).thenReturn("/TESTING");
        when(httpServletRequest.getMethod()).thenReturn("GET");

        loggingFilter.doFilter(httpServletRequest, httpServletResponse,
                filterChain);

        // verifies that a logging event is appended to the logger
        verify(mockAppender, times(1)).doAppend(captorLoggingEvent.capture());
        LoggingEvent loggingEvent = captorLoggingEvent.getAllValues().get(0);
        String loggingMessage = loggingEvent.getMessage();
        //test excludes date at the end of the log because will be dynamic based on when
        //request comes into the LoggingFilter
        assertEquals("IP 111.111.111.111 requested GET at /TESTING", loggingMessage);
    }

}