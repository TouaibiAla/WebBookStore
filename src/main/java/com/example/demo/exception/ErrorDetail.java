package com.example.demo.exception;

import java.util.Date;

import lombok.Data;

public class ErrorDetail {
	 private String message;
	    private String path;
	    private Date timestamp;

	    public ErrorDetail(String message, String path) {
	        this.message = message;
	        this.path = path;
	        this.timestamp= new Date();
	    }

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
	    
	    
}

