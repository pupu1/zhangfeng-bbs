package com.cn.bbs.exception;

public class BbsException extends RuntimeException {
	
	 private String message;  
     
	    public BbsException(String message){  
	        super(message);  
	        this.message=message;  
	    }  
	  
	  
	    public String getMessage() {  
	        return message;  
	    }  
	  
	  
	    public void setMessage(String message) {  
	        this.message = message;  
	    }  
	
}
