/**
 * 
 */
package com.advaizer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.advaizer.model.ErrorDto;

/**
 * @author sarvesh
 *
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger("GlobalControllerExceptionHandler");
	
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorDto handleGenericExeption(HttpServletRequest req, HttpServletResponse resp, Exception exception) throws IOException {
    	LOGGER.error("Request: " + req.getRequestURL() + " raised " + exception.getStackTrace());
    	exception.printStackTrace();
        resp.setStatus(500);
        ErrorDto error = new ErrorDto();
        error.setMessage("Internal server error");
        return error;
    }
}
