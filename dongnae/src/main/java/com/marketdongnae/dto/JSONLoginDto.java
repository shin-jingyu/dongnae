package com.marketdongnae.dto;

public class JSONLoginDto {
	// ajax security 테스트 중
	private String result; // success, fail
	private String message; // if fail, set
	

    public JSONLoginDto() {
        super();
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return "JSONResult [result=" + result + ", message=" + message +"]";
    }

	
}
