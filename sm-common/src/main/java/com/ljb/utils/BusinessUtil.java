package com.ljb.utils;

import com.ljb.Exception.BusinessException;

public class BusinessUtil {

	public static void isTrue(boolean expression, String error){
	    if(!expression) {
	        throw new BusinessException(error);
	    }
	}
	
}
