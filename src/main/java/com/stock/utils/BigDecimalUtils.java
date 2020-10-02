package com.stock.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

	private static final BigDecimal ZERO = new BigDecimal("0");
	private static final BigDecimal CEM = new BigDecimal("100");
	
	public static boolean greatherThan(BigDecimal one, BigDecimal two) {
		if (one == null || two == null)
			return false;
		
		return one.compareTo(two) == 1;
	}
	
	public static boolean lessThan(BigDecimal one, BigDecimal two) {
		if (one == null || two == null)
			return false;
		
		return one.compareTo(two) == -1;
	}
	
	public static boolean equalTo(BigDecimal one, BigDecimal two) {
		if (one == null || two == null)
			return false;
		
		return one.compareTo(two) == 0;
	}
	
	public static BigDecimal divideByHundred(BigDecimal a) {
		return a.divide(CEM);
	}
	
}
