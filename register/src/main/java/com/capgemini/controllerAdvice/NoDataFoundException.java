package com.capgemini.controllerAdvice;

public class NoDataFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String msg){
        super(msg);
    }
}