package com.stock.utils;

public class ObjectUtils {
	
	public static Object nvl(Object a, Object b) {
		return (a == null ? b : a);
	}

}
